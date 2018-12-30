package cafuc.flyeat.zy.service.impl;

import cafuc.flyeat.zy.mapper.UserMapper;
import cafuc.flyeat.zy.model.User;
import cafuc.flyeat.zy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User selectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }
}
