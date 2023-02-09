package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

//		BoardDto dto = new BoardDto();
//		BoardDao dao = new BoardDao();
//
//		if(nullCheck(request.getParameter("NAME")) || nullCheck(request.getParameter("COMMENT"))) {
//			request.setAttribute("isNull", true);
//		} else {
//		dto.setName(request.getParameter("NAME"));
//		dto.setComment(request.getParameter("COMMENT"));
//
//		dao.doInsert(dto);
//		}
		request.getRequestDispatcher("/WEB-INF/jsp/board.jsp").forward(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

//	private boolean nullCheck(String charString) {
//		boolean isNull = false;
//		if( charString == null || charString.equals("") ) {
//			isNull = true;
//		}
//		return isNull ;
//
//	}
}