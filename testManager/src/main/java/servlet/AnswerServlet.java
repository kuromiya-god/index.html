package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDAO;
import model.Question;

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // パラメータから回答を取得
        int answer = Integer.parseInt(request.getParameter("answer"));

        // 問題を取得
        int id = Integer.parseInt(request.getParameter("id"));
        QuestionDAO dao = new QuestionDAO();
        Question question = dao.findById(id);

        // 正解かどうか判定
        boolean isCorrect = (question.getAnswer() == answer);

        // 結果をリクエストスコープに保存
        request.setAttribute("isCorrect", isCorrect);
        request.setAttribute("question", question);

        // JSPへフォワード
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

}