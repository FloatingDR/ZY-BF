package cafuc.flyeat.zy.controller;

import cafuc.flyeat.zy.bean.ResponseBean;
import cafuc.flyeat.zy.service.CollegeService;
import cafuc.flyeat.zy.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/college")
@CrossOrigin
public class CollegeController {

    @Autowired
    StaffService staffService;

    @Autowired
    CollegeService collegeService;

    @GetMapping("/get_all")
    public ResponseBean getAllColleges() {
        return new ResponseBean(200, "success", collegeService.selectAll());
    }

    @GetMapping("/get_all_staff")
    public ResponseBean getAllStaffs() {
        return new ResponseBean(200, "success", staffService.selectAll());
    }
}
