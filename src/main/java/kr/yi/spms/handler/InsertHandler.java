package kr.yi.spms.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.ProjectDao;
import kr.yi.spms.model.Project;
import kr.yi.spms.util.MySqlSessionFactory;

public class InsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/insert.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			//인풋태그로 입력한 값들
			String name = req.getParameter("name");
			String content = req.getParameter("content");
			String sday = req.getParameter("sDay");
			String eday = req.getParameter("eDay");
			String select = req.getParameter("select");
			//선택된 셀렉태그 값
			
			Project pj = new Project();
			pj.setName(name);
			pj.setContent(content);
			pj.setSday(sday);
			pj.setEday(eday);
			pj.setProgress(select);
			
			SqlSession sqlsession = null;
			
			try {
				sqlsession = MySqlSessionFactory.openSession();
				
				ProjectDao pjDao = sqlsession.getMapper(ProjectDao.class);
				pjDao.insert(pj);
				
				sqlsession.commit();
						
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlsession.close();
			}
			
			return "/WEB-INF/view/list.jsp";
		}
		return null;
	}

}
