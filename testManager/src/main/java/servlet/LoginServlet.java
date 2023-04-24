package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		
		//ログイン処理の実行
		Login login = new Login(userId,pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		
		//ログイン処理の成否によって処理を分岐
		if(result) {//ログイン成功時
			//セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			
			//フォワード
			request.getRequestDispatcher("/WEB-INF/jsp/quizChoice.jsp").forward(request, response);
			
			/* session.invalidate();*/
			/* Object obj = session.getAttribute(userId);
			 System.out.println(obj);*/
			 
		}else {
			/*String logmessage = "ユーザーIDまたはパスワードのどちらかに誤りがあります";
			request.setAttribute("logmessage", logmessage);*/
			//リダイレクト
	        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}

}
