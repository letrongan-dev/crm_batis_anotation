package com.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dto.TaskDto;
import com.crm.mapper.TaskMapper;
import com.crm.model.Task;

@Service
public class TaskServiceImpl {
	
	@Autowired
	TaskMapper taskMapper;
	
	TaskDto convertEntitytoDTO(Task entity) {
		TaskDto dto = new TaskDto();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getDescription());
		dto.setStartDate(entity.getStartDate());
		dto.setEndDate(entity.getEndDate());
		dto.setUserId(entity.getUserId());
		
		return dto;
	}
	
	Task convertDTOtoEntity(TaskDto dto) {
		Task task = new Task();
		task.setId(dto.getId());
		task.setTitle(dto.getDescription());
		task.setDescription(dto.getDescription());
		task.setStartDate(dto.getStartDate());
		task.setEndDate(dto.getEndDate());
		task.setTaskId(dto.getTaskId());
		task.setUserId(dto.getUserId());
	
		return task;
		
	}
	
	Task convertDTOtoEntityUpdate(TaskDto dto) {
		Task task = taskMapper.getById(dto.getId());
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setStartDate(dto.getStartDate());
		task.setEndDate(dto.getEndDate());
		task.setTaskId(dto.getTaskId());
		task.setUserId(dto.getUserId());
	
		return task;
		
	}
	public List<TaskDto> getAll() {
		List<Task> lst = taskMapper.getAll();
		List<TaskDto> dto = new ArrayList<TaskDto>();
		for (Task task : lst) {
			dto.add(convertEntitytoDTO(task));
		}
		return dto;
	}

	
	public TaskDto getById(Integer id) {
		Task task = taskMapper.getById(id);
		TaskDto dto = convertEntitytoDTO(task);
		if(task != null) {
			return dto;
		}else {
			return null;
		}
		
	}


	public int add(TaskDto obj) {
		Task task = convertDTOtoEntity(obj);
		taskMapper.insert(task);
		return 0;
	}

	
	public int update(TaskDto obj) {
		Task task = convertDTOtoEntityUpdate(obj);
		taskMapper.update(task);
		return 0;
	}

	
	public int delete(Integer id) {
		taskMapper.delete(id);
		return 0;
	}
}
