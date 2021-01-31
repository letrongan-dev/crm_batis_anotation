package com.crm.model;

import java.util.Date;

public class Task {

	private Integer id;
	private Date endDate;
	private Date startDate;
	private Integer taskId;
	private String title;
	private Integer userId;
	private String description;
	
	public Task() {}

	public Task(Integer id, Date endDate, Date startDate, Integer taskId, String title, Integer userId,
			String description) {
		super();
		this.id = id;
		this.endDate = endDate;
		this.startDate = startDate;
		this.taskId = taskId;
		this.title = title;
		this.userId = userId;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
