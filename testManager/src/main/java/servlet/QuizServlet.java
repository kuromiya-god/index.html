package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionsetDAO;
import model.Ques;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/WEB-INF/jsp/quesMake2.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // jspから問題IDを取得
		/*request.setCharacterEncoding("UTF-8");
		String id1 = request.getParameter("ids");
		ArrayList<String>  ids = request.getParameter("ids").split(",");*/
		ArrayList<Integer>  questionId = new ArrayList<Integer>() ;
		questionId.add(1);
		questionId.add(2);
		int quesCount = 0;
		quesCount = questionId.size();
		
		
		for(Integer s:questionId) {
			System.out.println(s);
		}

		/*		for (int i = 0; i < ids1.length; i++) {
				    ids1[i] = Integer.parseInt(ids[i]);
				}
				*/
		// 問題を取得
		QuestionsetDAO dao = new QuestionsetDAO();
		ArrayList<Ques> question = dao.findByQuestion(questionId);
		
		int[] answerList = new int[question.size()];

		// questionからanswerを取り出して配列に格納
		for (int i = 0; i < question.size(); i++) {
		    Ques ques = question.get(i);
		    int answer = ques.getAnswer();
		    answerList[i] = answer;
		}

		
		for (Ques item : question) {
		    System.out.println(item);
		}
		
		
		// JSPに渡すために、問題をリクエストスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("question", question);
		session.setAttribute("quesCount", quesCount);
		session.setAttribute("answerList", answerList);
		

        // JSPへフォワード
    	request.getRequestDispatcher("/WEB-INF/jsp/quiz.jsp").forward(request, response);
    }
}