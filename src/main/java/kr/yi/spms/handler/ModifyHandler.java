package kr.yi.spms.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.ProjectDao;
import kr.yi.spms.dao.ProjectDaoImpl;
import kr.yi.spms.model.Project;
import kr.yi.spms.util.MySqlSessionFactory;

public class ModifyHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			String no = req.getParameter("no");
			int no2 = Integer.parseInt(no);
			SqlSession sqlsession = null;
			
			try {
				sqlsession = MySqlSessionFactory.openSession();		
				ProjectDao dao = ProjectDaoImpl.getInstance(sqlsession);
			
				Project project = dao.selectListByNo(no2);
				
				req.setAttribute("project", project);
				
				return "/WEB-INF/view/modify.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlsession.close();
			}
			}else if(req.getMethod().equalsIgnoreCase("post")) {//수정버튼 누르면 디비가 수정 되어야햇
				//찾은 번호는 필요없나?
				//인풋태그로 입력한 값들
				int no = Integer.parseInt(req.getParameter("no"));
				String name = req.getParameter("name");
				String content = req.getParameter("content");
				String sday = req.getParameter("sDay");
				String eday = req.getParameter("eDay");
				String select = req.getParameter("select");
				
				SqlSession sqlsession = null;
				
				try {
					sqlsession = MySqlSessionFactory.openSession();		
					ProjectDao dao = ProjectDaoImpl.getInstance(sqlsession);

					Project project = new Project(no, name, content, sday, eday, select);
					
					dao.update(project);
					
					sqlsession.commit();
					
					req.setAttribute("project", project);
					
					return "/WEB-INF/view/listDetail.jsp"; 
					//업데이트되고 리스트로 간다.근데 listDetail.jsp에서 project내용이 실려야되서				
					//req.setAttr 해서 업데이트한 project를 보냄.
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					sqlsession.close();
				}
			}
			return null;
	}

}
