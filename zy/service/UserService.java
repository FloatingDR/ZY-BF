package cafuc.flyeat.zy.service;

import cafuc.flyeat.zy.model.User;

public interface UserService {
    int insert(User record);
    int deleteById(Integer id);
    int update(User record);
    User selectById(Integer id);
    User selectByAccount(String account);
}
