package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuesUpDAO;
import model.Ques;

/**
 * Servlet implementation class quesMake
 */
@WebServlet("/quesMake")
public class quesMake extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/quesMake2.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String question = request.getParameter("question");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");
		String answer1 = request.getParameter("answer");
		int answer = Integer.parseInt(answer1);
		String explanation = request.getParameter("explanation");
		
		
		
		//Quesクラスをインスタンス化
		Ques ques = new Ques(question,option1,option2,option3,option4,answer,explanation);
		QuesUpDAO qd = new QuesUpDAO(); 
		qd.quesUpDAO(ques);
		
		//フォワード
		request.getRequestDispatcher("/WEB-INF/jsp/quesMake2.jsp").forward(request, response);
	}

}
