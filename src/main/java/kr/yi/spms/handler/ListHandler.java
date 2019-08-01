package kr.yi.spms.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.ProjectDao;
import kr.yi.spms.model.Project;
import kr.yi.spms.util.MySqlSessionFactory;

public class ListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
		SqlSession sqlsession = null;
		sqlsession = MySqlSessionFactory.openSession();
		
		ProjectDao dao = sqlsession.getMapper(ProjectDao.class);
		List<Project> list = dao.selectByAll();
		
		req.setAttribute("list", list);
		
		
		
		}
		
		return "/WEB-INF/view/list.jsp";
	}

}
