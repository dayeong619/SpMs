package kr.yi.spms.dao;

import java.sql.SQLException;
import java.util.List;

import kr.yi.spms.model.Project;

public interface ProjectDao {
	
	public void insert(Project pj) throws SQLException;
	public List<Project> selectByAll() throws SQLException;
	public Project selectListByNo(int no) throws SQLException;
	public void update(Project pj) throws SQLException;
	public void delete(int no) throws SQLException;
}
