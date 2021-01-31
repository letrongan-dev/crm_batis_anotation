package com.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.crm.model.User;

@Mapper
public interface UserMapper {

	@Select("select *  from user")
	List<User> findAll();
	
	@Select("select *  from user where id = #{id}")
	User getById(int id);
	
	@Insert(" INSERT INTO USER (ID, NAME, EMAIL, PASSWORD, ROLE) VALUES (#{id}, #{name}, #{email}, #{password}, #{role})")
	int insert(User user);
	
	@Update("update user set name=#{name}, email=#{email}, role=#{role} where id=#{id};")
	int update(User user);
	
	@Delete("delete from user where id = #{id}")
	int delete (int id);

	@Select("select *  from user where email = #{email}")
	User findByEmail(String email);
}
