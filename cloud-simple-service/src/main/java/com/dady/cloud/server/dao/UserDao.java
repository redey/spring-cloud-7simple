package com.dady.cloud.server.dao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.dady.cloud.server.model.User;

@Mapper
public interface UserDao {
	@Select("select * from user where name = #{name}")
	User findUserByName(@Param("name") String name);
}
