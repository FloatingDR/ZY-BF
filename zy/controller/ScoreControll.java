package cafuc.flyeat.zy.controller;

import cafuc.flyeat.zy.bean.ResponseBean;
import cafuc.flyeat.zy.service.CourseScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
@CrossOrigin
public class ScoreControll {

    @Autowired
    CourseScoreService service;

    @GetMapping("/get_by_course/{id}")
    public ResponseBean getByCourse(@PathVariable int id) {
        return new ResponseBean(200, "success", service.selectByClassCourseLink(id));
    }
}
