package edu.du.sb1011.service;

import edu.du.sb1011.dto.UserDto;
import org.springframework.stereotype.Service;


public interface UserService {
    UserDto getUserByIdAndPassword(String id,String password);
}
