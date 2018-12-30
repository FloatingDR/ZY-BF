package cafuc.flyeat.zy.controller;

import cafuc.flyeat.zy.bean.ResponseBean;
import cafuc.flyeat.zy.model.Student;
import cafuc.flyeat.zy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public ResponseBean getAll() {
        return new ResponseBean(200, "success", studentService.selectAll());
    }

    @PostMapping("/add")
    public ResponseBean addStudent(@RequestBody Student newStudent) {
        if (studentService.insert(newStudent) > 0) {
            return new ResponseBean(200, "success", null);
        } else {
            return new ResponseBean(500, "failed", null);
        }
    }

    @GetMapping("/get_by_class/{classid}")
    public ResponseBean getByClass(@PathVariable int classid) {
        return new ResponseBean(200, "success", studentService.selectByClassId(classid));
    }

    @GetMapping("/get_by_course/{courseid}")
    public ResponseBean getByCourse(@PathVariable int courseid) {
        return new ResponseBean(200, "success", studentService.selectByCourseId(courseid));
    }
}