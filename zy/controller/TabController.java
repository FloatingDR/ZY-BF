package cafuc.flyeat.zy.controller;

import cafuc.flyeat.zy.bean.ResponseBean;
import cafuc.flyeat.zy.model.StuClass;
import cafuc.flyeat.zy.service.CollegeService;
import cafuc.flyeat.zy.service.StuClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tab")
@CrossOrigin
public class TabController {

    @Autowired
    CollegeService collegeService;

    @Autowired
    StuClassService stuClassService;

    @GetMapping("/colleges")
    public ResponseBean getColleges() {
        return new ResponseBean(200, "colleges data", collegeService.selectAll());
    }

    @GetMapping("/classes_by_major/{majorid}")
    public ResponseBean getClassesByMajor(@PathVariable int majorid) {
        return new ResponseBean(200, "success", stuClassService.getByMajor(majorid));
    }

    @GetMapping("/class_years")
    public ResponseBean getClassYears() {
        return new ResponseBean(200, "succcess", stuClassService.getStuYears());
    }

}
