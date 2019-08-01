package kr.yi.spms.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.ProjectDao;
import kr.yi.spms.dao.ProjectDaoImpl;
import kr.yi.spms.model.Project;
import kr.yi.spms.util.MySqlSessionFactory;

public class ListDetailHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
	
		SqlSession sqlsession = null;
			
		try {
			sqlsession = MySqlSessionFactory.openSession();		
			ProjectDao dao = ProjectDaoImpl.getInstance(sqlsession);

			String no = req.getParameter("no");
			int no2 = Integer.parseInt(no);
			
			Project project = dao.selectListByNo(no2);
			
			req.setAttribute("project", project);
			
			return "/WEB-INF/view/listDetail.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
		
		
		}
		return null;
		
	}

}
