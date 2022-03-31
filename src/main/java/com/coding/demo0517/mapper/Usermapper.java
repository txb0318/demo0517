package com.coding.demo0517.mapper;

import com.coding.demo0517.demo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface Usermapper extends Mapper<User> {

    @Select("select id,name,password from tab_user where name = #{name}")
    User selectUser(@Param("name") String name);

    @Insert("INSERT into tab_user(id,name,password) VALUES(#{id},#{name},#{password})")
    int saveUser(@Param("name") String name, @Param("password") String password);
}
