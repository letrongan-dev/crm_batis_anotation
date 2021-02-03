package com.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.crm.model.Task;
import com.crm.model.TaskAndUser;

@Mapper
public interface TaskMapper {

	@Select("select * from task")
	List<Task> getAll();
	
	@Insert("insert into task (title, description, start_date, end_date, task_id, user_id) values (#{title},#{description},#{startDate},#{endDate},#{taskId},#{userId} )")
	int insert(Task task);
	
	@Update("update task set title=#{title}, description=#{description}, start_date=#{startDate}, end_date=#{endDate}, \r\n" + 
			" task_id=#{taskId}, user_id=#{userId}  where id=#{id};")
	int update(Task task);
	@Delete("delete from task where id = #{id}")
	int delete(int id);

	@Select("select * from task where id=#{id}")
	Task getById(int id);
	
	@Select("select * from task t inner join user u on t.user_id = u.id")
	@Results(value = {
			@Result(property = "id", column = "ID"),
			@Result(property = "startDate", column = "start_date"),
			@Result(property = "endDate", column = "end_date"),
			@Result(property = "taskId", column = "task_id"),
			@Result(property = "title", column = "title"),
			@Result(property = "userId", column = "user_id"),
			@Result(property = "description", column = "description"),
			@Result(property = "nameUser", column = "name")		
	})
	List<TaskAndUser> findAllRelational();
	

}
