package cafuc.flyeat.zy.controller;

import cafuc.flyeat.zy.bean.ResponseBean;
import cafuc.flyeat.zy.model.User;
import cafuc.flyeat.zy.service.UserService;
import cafuc.flyeat.zy.shiro.JWTUtil;
import cafuc.flyeat.zy.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseBean login(@RequestBody User loginUser) {
        User user = userService.selectByAccount(loginUser.getLoginAccount());
        if (user == null) {
            return new ResponseBean(404, "not found", null);
        }
        if (MD5Util.encode(loginUser.getLoginPassword()).equals(user.getLoginPassword())) {
            String token = JWTUtil.sign(user.getLoginAccount(), user.getLoginPassword());
            user.setLoginPassword(null);
            return new ResponseBean(200, token, user);
        } else {
            return new ResponseBean(500, "username or password error", null);
        }
    }
}