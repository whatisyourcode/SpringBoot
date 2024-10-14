package edu.du.sb1011.service;

import edu.du.sb1011.dto.UserDto;
import edu.du.sb1011.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDto getUserByIdAndPassword(String id, String password) {
        return userMapper.selectUserByIdAndPassword(id, password);
    }
}
