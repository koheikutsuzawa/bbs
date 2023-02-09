package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.BoardDto;

@WebServlet("/result")
public class BoardResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardResultServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String NAME = request.getParameter("NAME");
		String COMMENT = request.getParameter("COMMENT");

		request.setAttribute("NAME", NAME);
		request.setAttribute("COMMENT", COMMENT );

		BoardDto dto = new BoardDto();
		BoardDao dao = new BoardDao();

		if(nullCheck(request.getParameter("COMMENT"))) {
			/*コメントエラー時にアラート表示してるのでこの部分だけ現在使ってない処理()
			request.setAttribute("isNull", true);
			request.getRequestDispatcher("/WEB-INF/jsp/boardError.jsp").forward(request, response);*/
		} else if(nullCheck(request.getParameter("NAME"))) {
			request.setAttribute("NAME","匿名さん");
			dto.setName("匿名さん");
			dto.setComment(request.getParameter("COMMENT"));
			dao.doInsert(dto);
			request.getRequestDispatcher("/WEB-INF/jsp/boardResult.jsp").forward(request, response);
		} else {
			dto.setName(request.getParameter("NAME"));
			dto.setComment(request.getParameter("COMMENT"));
			dao.doInsert(dto);
			request.getRequestDispatcher("/WEB-INF/jsp/boardResult.jsp").forward(request, response);
		}
	}
    private boolean nullCheck(String charString) {
		boolean isNull = false;
		if( charString == null || charString.equals("") ) {
			isNull = true;
		}
		return isNull ;

	}
}