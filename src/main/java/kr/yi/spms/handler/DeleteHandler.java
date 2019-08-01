package kr.yi.spms.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;


import kr.yi.spms.util.MySqlSessionFactory;
import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.ProjectDao;
import kr.yi.spms.dao.ProjectDaoImpl;

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
			int no = Integer.parseInt(req.getParameter("no"));
			
			SqlSession sqlSession = null;
			try {
				sqlSession = MySqlSessionFactory.openSession();
				ProjectDao dao = ProjectDaoImpl.getInstance(sqlSession);
				dao.delete(no);
				sqlSession.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			
			res.sendRedirect("list.do");
			
			return null;
	}

}
