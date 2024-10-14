package edu.du.sb1011.mapper;

import edu.du.sb1011.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    UserDto selectUserByIdAndPassword(@Param("id") String id, @Param("password") String password);
}
