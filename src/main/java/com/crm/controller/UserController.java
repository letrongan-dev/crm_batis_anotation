package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.dto.UserDto;
import com.crm.service.impl.UserServiceImpl;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getAll(){
		List<UserDto> dtos = userServiceImpl.findAll();
		return new ResponseEntity<List<UserDto>>(dtos, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getById(@PathVariable int id){
		try {
			UserDto dto = userServiceImpl.getById(id);
			return new ResponseEntity<UserDto>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/add")
	public ResponseEntity<Object> insert(@RequestBody UserDto dto, BindingResult result){
		try {
			if(result.hasErrors()) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}else {
				userServiceImpl.insert(dto);
				return new ResponseEntity<Object>(HttpStatus.CREATED);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<UserDto> update(@PathVariable int id,@RequestBody UserDto dto){
		try {
			if(userServiceImpl.getById(id) == null) {
				return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
			}
			userServiceImpl.update(dto);
			return new ResponseEntity<UserDto>(HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDto> delete(@PathVariable int id) {
		try {
			userServiceImpl.delete(id);
			return new ResponseEntity<UserDto>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
	}
}
