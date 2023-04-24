package servlet;
//削除ページへの遷移のservlet
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuesListSetDAO;
import model.Ques;

/**
 * Servlet implementation class GoDelete
 */
@WebServlet("/GoDelete")
public class GoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuesListSetDAO l = new QuesListSetDAO();
		ArrayList<Ques> quesList = l.findByQuesList();
		HttpSession session = request.getSession();
		session.setAttribute("quesList",quesList);
		request.getRequestDispatcher("/WEB-INF/jsp/delete.jsp").forward(request, response);
	}

}
