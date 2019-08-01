package kr.yi.spms.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.yi.spms.dao.ProjectDao;
import kr.yi.spms.model.Project;
import kr.yi.spms.util.MySqlSessionFactory;


public class ProjectDaoTest {
	
	@Test
	public void selectByAll () {
		SqlSession sqlsession = null;
		
		try {
			sqlsession = MySqlSessionFactory.openSession();
			ProjectDao dao = sqlsession.getMapper(ProjectDao.class);
			
			List<Project> list = dao.selectByAll();
			
			for(int i=0;i<list.size();i++) {
				Project a = list.get(i);
				System.out.println(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
	}

	@Test
	public void insert() {
		SqlSession sqlSession =  null;
		
		try {
			sqlSession = MySqlSessionFactory.openSession();
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			Project pj1= new Project();
			
			pj1.setName("이름");
			pj1.setContent("내용");
			pj1.setSday("2019-01-01");
			pj1.setEday("2019-01-02");
			pj1.setProgress("진행");	
			dao.insert(pj1);
			sqlSession.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void update() {
		SqlSession sqlSession =  null;
		
		try {
			sqlSession = MySqlSessionFactory.openSession();
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			Project article = new Project();
			
			article.setNo(6);
			article.setName("이름");
			article.setContent("내용");
			article.setSday("2019-01-01");
			article.setEday("2019-01-02");
			article.setProgress("진행");	
			dao.update(article);
			sqlSession.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	

	@Test
	public void delete() {
		SqlSession sqlSession =  null;
		
		try {
			sqlSession = MySqlSessionFactory.openSession();
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			Project article = new Project();
			
			article.setNo(6);
			dao.delete(6);
			sqlSession.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void selectListByNo () {
		SqlSession sqlsession = null;
		
		try {
			sqlsession = MySqlSessionFactory.openSession();
			ProjectDao dao = sqlsession.getMapper(ProjectDao.class);
			Project article = new Project();

			article.setNo(13);
			dao.selectListByNo(13);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
	}

	
	
}








































