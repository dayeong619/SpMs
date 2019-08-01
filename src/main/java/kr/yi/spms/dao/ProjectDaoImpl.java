package kr.yi.spms.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.model.Project;

public class ProjectDaoImpl implements ProjectDao {
	private static final String namespace = "kr.yi.spms.dao.ProjectDao";
	private static final ProjectDaoImpl dao = new ProjectDaoImpl();
	
	SqlSession sqlSession;
	
	public static ProjectDao getInstance(SqlSession sqlSession) { //sqlsession은 핸들러에서 열고 닫기 함 (여기서 안하고)
		dao.sqlSession = sqlSession; //static 안의 변수만 사용가능 해서 dao 사용.
		return dao;
	}
	
	@Override
	public List<Project> selectByAll() throws SQLException {
		return sqlSession.selectList(namespace + ".selectByAll");
	}
	
	@Override
	public void insert(Project pj) throws SQLException {		
		sqlSession.insert(namespace + ".insert", pj);	
	}

	@Override
	public Project selectListByNo(int no) throws SQLException {
		return sqlSession.selectOne(namespace + ".selectListByNo", no);
	}

	@Override
	public void update(Project pj) throws SQLException {
		sqlSession.update(namespace + ".update", pj);	
		
	}

	@Override
	public void delete(int no) throws SQLException {
		sqlSession.delete(namespace + ".delete", no);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}












