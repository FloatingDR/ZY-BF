package cafuc.flyeat.zy.controller;

import cafuc.flyeat.zy.bean.ResponseBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UtilController {
    @RequestMapping("/401")
    public ResponseBean forbidden() {
        return new ResponseBean(401, "not allowed", null);
    }
}
