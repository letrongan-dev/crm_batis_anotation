package com.crm.controller;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.dto.TaskDto;
import com.crm.mapper.TaskMapper;
import com.crm.model.TaskAndUser;
import com.crm.service.impl.TaskServiceImpl;

@RestController
@RequestMapping(value = "/api/task")
public class TaskController {

	@Autowired
	private TaskServiceImpl taskSer;
	
	@Autowired
	private TaskMapper taskRel;
	
	@GetMapping("/all")
	public ResponseEntity<List<TaskDto>> get(){
		try {
			List<TaskDto> lst = taskSer.getAll();
			return new ResponseEntity<List<TaskDto>>(lst, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<TaskDto>>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Object> insert(@RequestBody TaskDto dto){
		try {
			taskSer.add(dto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable int id, @RequestBody TaskDto dto){
		try {
			taskSer.update(dto);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		try {
			taskSer.delete(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/all/rel")
	public ResponseEntity<List<TaskAndUser>> findRel(){
		try {
			List<TaskAndUser> lst = taskRel.findAllRelational();
			return new ResponseEntity<List<TaskAndUser>>(lst, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<TaskAndUser>>(HttpStatus.BAD_REQUEST);
	}
}
