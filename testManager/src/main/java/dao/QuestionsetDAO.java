package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Ques;

public class QuestionsetDAO {
	
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/testManager";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "password";

    public ArrayList<Ques> findByQuestion(ArrayList<Integer> questionId) {
    	ArrayList<Ques> questionList = new ArrayList<Ques>();
    	ResultSet rs = null;
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
            // データベースに接続
           

            // SQL文を準備
        	StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM question WHERE deleted = false AND id IN (");
            for (int i = 0; i < questionId.size(); i++) {
                sb.append("?");
                if (i != questionId.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            PreparedStatement pStmt = conn.prepareStatement(sb.toString());
            for (int i = 0; i < questionId.size(); i++) {
                pStmt.setInt(i + 1, questionId.get(i));
            }
           

            // SQL文を実行し、結果を取得
            rs = pStmt.executeQuery();

            // 結果を1件取得できた場合、Questionインスタンスを生成
            // そして、選択肢も取得してQuestionインスタンスにセット
            while (rs.next()) {
            	String question = rs.getString("question");
            	String option1 = rs.getString("option1");
            	String option2 = rs.getString("option2");
            	String option3 = rs.getString("option3");
            	String option4 = rs.getString("option4");
        		int answer = rs.getInt("answer");
        		String explanation = rs.getString("explanation");
        		int id = rs.getInt("id");
        		Ques ques = new Ques(question,option1,option2,option3,option4,answer,explanation,id);
        		questionList.add(ques);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return questionList;
	    }
     }
    
