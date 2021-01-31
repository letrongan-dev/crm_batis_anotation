package com.crm.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TaskDto {

	private int id;
	private String title;
	private Date startDate;
	private Date endDate;
	private String description;
	private int taskId;
	private int userId;
	
	public TaskDto() {}

	
	public TaskDto(int id, String title, Date startDate, Date endDate, String description, int taskId, int userId) {
		super();
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.taskId = taskId;
		this.userId = userId;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date dateStart) {
		this.startDate = dateStart;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getTaskId() {
		return taskId;
	}


	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return (id + " "+ title+" start date: "+startDate+" end date: "+endDate+" user: "+userId+" "+taskId );
		
	}

}
