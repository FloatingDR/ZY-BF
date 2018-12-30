package cafuc.flyeat.zy.controller;

import cafuc.flyeat.zy.bean.AddCourseBean;
import cafuc.flyeat.zy.bean.ResponseBean;
import cafuc.flyeat.zy.model.ClassCourseLink;
import cafuc.flyeat.zy.model.Course;
import cafuc.flyeat.zy.model.StuClass;
import cafuc.flyeat.zy.model.Teacher;
import cafuc.flyeat.zy.service.ClassCourseService;
import cafuc.flyeat.zy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    ClassCourseService classCourseService;

    @GetMapping("/all")
    public ResponseBean all() {
        return new ResponseBean(200, "all course", courseService.selectAll());
    }

    @GetMapping("/search_common/{name}")
    public ResponseBean searchZyCourse(@PathVariable String name) {
        return new ResponseBean(200, "search course", courseService.searchCourse(name));
    }

    @GetMapping("/get_by_class/{classid}")
    public ResponseBean getByClassid(@PathVariable int classid) {
        return new ResponseBean(200, "course by class", courseService.selectCourseByClass(classid));
    }

    @GetMapping("/get_link_by_class/{classid}")
    public ResponseBean getLinkByClass(@PathVariable int classid) {
        return new ResponseBean(200, "links", classCourseService.selectByClass(classid));
    }

    @GetMapping("/get_zylink_by_class/{classid}")
    public ResponseBean getZyLinkByClass(@PathVariable int classid) {
        return new ResponseBean(200, "links", classCourseService.selectZyByClass(classid));
    }

    @GetMapping("/get_zy_info/{id}")
    public ResponseBean getZyInfo(@PathVariable int id) {
        ClassCourseLink link = classCourseService.selectById(id);
        if (link == null) {
            return new ResponseBean(200, "info", null);
        }
        return new ResponseBean(200, "inks", courseService.selectById(link.getCourseId()));
    }

    @PostMapping("/common_add")
    @Transactional
    public ResponseBean addCommonCourse(@RequestBody AddCourseBean bean) {
        Course course = new Course();
        course.setZyCourse(false);
        course.setCourseName(bean.getCourseName());
        courseService.insert(course);

        for (Teacher teacher : bean.getTeachers()) {
            courseService.insertTeacherCourseLink(teacher.getTeacherId(), course.getCourseId());
        }

        for (StuClass stuClass : bean.getClasses()) {
            courseService.insertClassCourseLink(stuClass.getClassId(), course.getCourseId());
        }
        return new ResponseBean(200, "insert success", null);
    }

    @PostMapping("/zy_add")
    @Transactional
    public ResponseBean addZYCourse(@RequestBody AddCourseBean bean) {

        Course course = new Course();
        course.setZyCourse(true);
        course.setCourseName(bean.getCourseName());
        courseService.insert(course);

        for (Teacher teacher : bean.getTeachers()) {
            courseService.insertTeacherCourseLink(teacher.getTeacherId(), course.getCourseId());
        }

        for (StuClass stuClass : bean.getClasses()) {
            courseService.insertClassCourseLink(stuClass.getClassId(), course.getCourseId());
        }

        for (Course commonCourse : bean.getSubCourses()) {
            courseService.setParentCourse(commonCourse.getCourseId(), course.getCourseId());
        }
        return new ResponseBean(200, "insert success", null);
    }

}
