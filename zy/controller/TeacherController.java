package cafuc.flyeat.zy.controller;

import cafuc.flyeat.zy.bean.ResponseBean;
import cafuc.flyeat.zy.handler.TeacherImportHandler;
import cafuc.flyeat.zy.model.Teacher;
import cafuc.flyeat.zy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    TeacherImportHandler teacherImportHandler;


    @PostMapping("/add")
    public ResponseBean addTeacher(@RequestBody Teacher newTeacher) {
        if (teacherService.insert(newTeacher) > 0) {
            return new ResponseBean(200, "success", null);
        } else {
            return new ResponseBean(500, "failed", null);
        }
    }

    @GetMapping("/get_wteacher")
    public ResponseBean getWTeacher() {
        return new ResponseBean(200, "wteachers", teacherService.getWTeachers());
    }

    @GetMapping("/get_zteacher")
    public ResponseBean getZTeacher() {
        return new ResponseBean(200, "wteachers", teacherService.getZTeachers());
    }

    @GetMapping("/get_by_staff/{staffid}")
    public ResponseBean getByStaff(@PathVariable int staffid) {
        return new ResponseBean(200, "success", teacherService.selectByStaffId(staffid));
    }

    @GetMapping("/search_by_name/{name}")
    public ResponseBean searchByName(@PathVariable String name) {
        return new ResponseBean(200, "search teacher", teacherService.searchByName(name));
    }
}
