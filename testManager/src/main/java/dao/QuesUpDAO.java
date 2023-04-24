package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Ques;



public class QuesUpDAO {
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/testManager";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "password";
	
	public void quesUpDAO(Ques ques) {
		/*Account account = null;*/
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "INSERT INTO question(question,option1,option2,option3,option4,answer,explanation) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setString(1, ques.getQuestion());
			pS.setString(2, ques.getOption1());
			pS.setString(3, ques.getOption2());
			pS.setString(4, ques.getOption3());
			pS.setString(5, ques.getOption4());
			pS.setInt(6, ques.getAnswer());
			pS.setString(7, ques.getExplanation());
			
			//INSERT文を実行する
			int result = pS.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		//見つかったユーザーまたはNULLを返す
		return;
	}
	
	public void quesEditDAO(Ques ques) {
		/*Account account = null;*/
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "UPDATE question SET question=?,option1=?,option2=?,option3=?,option4=?,answer=?,explanation=? WHERE id = ? ";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setString(1, ques.getQuestion());
			pS.setString(2, ques.getOption1());
			pS.setString(3, ques.getOption2());
			pS.setString(4, ques.getOption3());
			pS.setString(5, ques.getOption4());
			pS.setInt(6, ques.getAnswer());
			pS.setString(7, ques.getExplanation());
			pS.setInt(8, ques.getId());
			
			//INSERT文を実行する
			int result = pS.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		//見つかったユーザーまたはNULLを返す
		return;
	}
	
	public void quesDeleteDAO(Ques ques) {
		/*Account account = null;*/
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文を準備
			String sql = "UPDATE question SET deleted = true WHERE id = ? ";
			PreparedStatement pS = conn.prepareStatement(sql);
			pS.setInt(1, ques.getId());
			
			//INSERT文を実行する
			int result = pS.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		//見つかったユーザーまたはNULLを返す
		return;
	}
	
}
