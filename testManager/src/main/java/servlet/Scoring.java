package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Scoring
 */
@WebServlet("/Scoring")
public class Scoring extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Object count = session.getAttribute("quesCount");
		Object question = session.getAttribute("question");
		int[] answerList = (int[])session.getAttribute("answerList");
		
		int numOfQuestions = 0;
        if (count instanceof Integer) {
            numOfQuestions = (int) count;
        } else {
            // count が null または Integer 以外の場合はエラーとして処理を中断
            throw new ServletException("quesCount の値が不正です。");
        } // 質問数
		System.out.println(numOfQuestions);
	    int[] answers = new int[numOfQuestions]; // 回答を保存するための配列
	    boolean[] ansCheck = new boolean[numOfQuestions];
	    
	    
	    // 各質問の回答を配列に保存
	    for (int i = 1; i <= numOfQuestions; i++) {
            String answer = request.getParameter("answer_" + i);
            if (answer != null) {
                answers[i-1] = Integer.parseInt(answer);
            } else {
                // answer が null の場合はエラーとして処理を中断
                throw new ServletException("answer_" + i + " の値が不正です。");
            }
        }

        // answerList が null の場合はエラーとして処理を中断
        if (answerList == null) {
            throw new ServletException("answerList の値が null です。");
        }
	   	    
	    //回答と正解を正誤判定して配列に格納
	    for (int i = 0; i < numOfQuestions; i++) {
	        ansCheck[i] = (answers[i] == answerList[i]);
	    }
	    
	    for(int i = 0; i <= numOfQuestions; i++) {
	    System.out.println(ansCheck[i]);
	    }
	    
	    session.setAttribute("answers", answers);
	    session.setAttribute("ansCheck", ansCheck);
	    
	    request.getRequestDispatcher("/WEB-INF/jsp/scoring.jsp").forward(request, response);
	}

}
