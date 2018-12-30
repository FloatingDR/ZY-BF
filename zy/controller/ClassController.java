package cafuc.flyeat.zy.controller;

import cafuc.flyeat.zy.bean.ResponseBean;
import cafuc.flyeat.zy.service.StuClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
@CrossOrigin
public class ClassController {

    @Autowired
    StuClassService stuClassService;

    @GetMapping("/get_all")
    public ResponseBean getAllClasses() {
        return new ResponseBean(200, "all classes", stuClassService.getAll());
    }

    @GetMapping("/years")
    public ResponseBean getClassYears() {
        return new ResponseBean(200, "success", stuClassService.getStuYears());
    }

    @GetMapping("/get_by_major/{majorid}")
    public ResponseBean getByMajor(@PathVariable int majorid) {
        return new ResponseBean(200, "success", stuClassService.getByMajor(majorid));
    }

    @GetMapping("/get_by_id/{classid}")
    public ResponseBean getById(@PathVariable int classid) {
        return new ResponseBean(200, "success", stuClassService.getById(classid));
    }

    @GetMapping("/get_zy_class")
    public ResponseBean getZyClasses() {
        return new ResponseBean(200, "success", stuClassService.getZyClasses());
    }

    @GetMapping("/search_by_name/{name}")
    public ResponseBean searchByName(@PathVariable String name) {
        return new ResponseBean(200, "search class", stuClassService.searchByName(name));
    }
}