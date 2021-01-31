package com.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dto.UserDto;
import com.crm.mapper.UserMapper;
import com.crm.model.User;

@Service
public class UserServiceImpl {

	UserDto convertEntitytoDTO(User user) {
			UserDto dto = new UserDto();
			dto.setId(user.getId());
			dto.setName(user.getName());
			dto.setEmail(user.getEmail());
			dto.setPassword(user.getPassword());
			dto.setRole(user.getRole());
			return dto;
		}
	User convertDTOtoEntity(UserDto dto) {
			User user = new User();
			user.setId(dto.getId());
			user.setName(dto.getName());
			user.setEmail(dto.getEmail());
			user.setPassword(dto.getPassword());
			user.setRole(dto.getRole());
			return user;
		}
	User convertDTOtoEntityUpdate(UserDto dto) {
		User user = userMapper.getById(dto.getId());
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setRole(dto.getRole());
		return user;
	}
	
	
	public String hashPassword(String password) {
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
		return hashed;
	}
	
	@Autowired
	UserMapper userMapper;
	
	public List<UserDto> findAll(){
		List<User> lst = userMapper.findAll();
		List<UserDto> dtos = new ArrayList<UserDto>();
		for (User user : lst) {
			dtos.add(convertEntitytoDTO(user));
		}
		return dtos;
	}
	
	public UserDto getById(int id) {
		User user = userMapper.getById(id);
		UserDto dto = convertEntitytoDTO(user);
		return dto;
	}
	
	public int insert(UserDto dto) {
		User user = convertDTOtoEntity(dto);
		user.setPassword(hashPassword(dto.getPassword()));
		userMapper.insert(user);
		return 0;
	}
	
	public int update(UserDto obj) {
		User user = convertDTOtoEntityUpdate(obj);
		userMapper.update(user);
		return 0;
	}

	
	public int delete(Integer id) {
		userMapper.delete(id);
		return 0;
	}
}
