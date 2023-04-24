package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Ques;

public class QuesListSetDAO {
	
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/testManager";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "password";

    public ArrayList<Ques> findByQuesList() {
    	ArrayList<Ques> quesList = new ArrayList<>();
    	ResultSet rs = null;
    	String sql = "SELECT id,question FROM question WHERE deleted = false";
     // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)){
        	
           
           // SQL文を実行し、結果を取得
           rs = stmt.executeQuery();

           // 結果を処理
           while (rs.next()) {
               int id = rs.getInt("id");
               String question = rs.getString("question");
               Ques ques = new Ques(question,id);
               quesList.add(ques);
               
           }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return quesList;
	    }
   }
    
