package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Ques;

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
		Object question11 = session.getAttribute("question1");
		Object option111 = session.getAttribute("option11");
		Object option211 = session.getAttribute("option21");
		Object option311 = session.getAttribute("option31");
		Object option411 = session.getAttribute("option41");
		Object explanation11 = session.getAttribute("explanation1");
		ArrayList<Integer> answerList = (ArrayList<Integer>)session.getAttribute("answerList");
		
		
		int numOfQuestions = 0;
		try {
		    if (count instanceof Integer) {
		        numOfQuestions = (int) count;
		    } else {
		        // count が null または Integer 以外の場合はエラーとして処理を中断
		        throw new ServletException("quesCount の値が不正です。");
		    }
		} catch (ServletException e) {
		    e.printStackTrace();
		}
        
		System.out.println("numがnullか" +numOfQuestions);
		ArrayList<Integer>answers = new ArrayList<>(); // 回答を保存するための配列
	    ArrayList<Boolean> ansCheck = new ArrayList<>();
	    
	    
	    // 各質問の回答を配列に保存
	    for (int i = 0; i < numOfQuestions; i++) {
            String answer = request.getParameter("answer_" + (i+1));
            if (answer != null) {
                System.out.println("answerが１～４で入っているか"+answer);
            	answers.add(i,Integer.parseInt(answer));
                
            } else {
                // answer が null の場合はエラーとして処理を中断
                throw new ServletException("answer_" + i + " の値が不正です。");
            }
        }

        // answerList が null の場合はエラーとして処理を中断
        if (answerList == null) {
            throw new ServletException("answerList の値が null です。");
        }
	   	System.out.println("入力した回答が入っているか" +answers.get(0));
	   	System.out.println("正解が入っているか"+answerList.get(0));
	    //回答と正解を正誤判定して配列に格納
	    for (int i = 0; i < numOfQuestions; i++) {
	        ansCheck.add(answers.get(i) == answerList.get(i));
	    }
	    
	    for(int i = 0; i < numOfQuestions; i++) {
	    System.out.println("正誤判定" +ansCheck.get(i));
	    }
	    //Ques型にするため一度sessionスコープに格納されているquestionからanswerなどを各ArrayListへ格納
	    ArrayList<Ques> newquestion= new ArrayList<Ques>();
	    if (question instanceof ArrayList) {
	        newquestion = (ArrayList<Ques>) question;
	        // コンストラクタにlistを渡す
	    }
	    
		ArrayList<String> question1 = new ArrayList<>();
		ArrayList<String> option11 = new ArrayList<>();
		ArrayList<String> option21 = new ArrayList<>();
		ArrayList<String> option31 = new ArrayList<>();
		ArrayList<String> option41 = new ArrayList<>();
		ArrayList<Integer> answer1 = new ArrayList<>();
		ArrayList<String> explanation1 = new ArrayList<>();
		/*
		for (Ques ques : newquestion) {
		    question1.add(ques.getQuestion());
		    option11.add(ques.getOption1());
		    option21.add(ques.getOption2());
		    option31.add(ques.getOption3());
		    option41.add(ques.getOption4());
		    answer1.add(ques.getAnswer());
		    explanation1.add(ques.getExplanation());
		    }*/
	    if (question11 instanceof ArrayList) {
	        question1 = (ArrayList<String>) question11;
	        // コンストラクタにlistを渡す
	    }
	    if (option111 instanceof ArrayList) {
	    	option11 = (ArrayList<String>) option111;
	        // コンストラクタにlistを渡す
	    }
	    if (option211 instanceof ArrayList) {
	    	option21 = (ArrayList<String>) option211;
	        // コンストラクタにlistを渡す
	    }
	    if (option311 instanceof ArrayList) {
	    	option31 = (ArrayList<String>) option311;
	        // コンストラクタにlistを渡す
	    }
	    if (option411 instanceof ArrayList) {
	    	option41 = (ArrayList<String>) option411;
	        // コンストラクタにlistを渡す
	    }
	    if (explanation11 instanceof ArrayList) {
	    	explanation1 = (ArrayList<String>) explanation11;
	        // コンストラクタにlistを渡す
	    }
	    
	    System.out.println("Arrayが持ってこれてるか" +question1.get(0));
	    System.out.println("選択肢"+option11.get(0));
	    System.out.println("選択肢"+option21.get(0));
	    System.out.println("選択肢"+option31.get(0));
	    System.out.println("選択肢"+option41.get(0));
	    System.out.println("正解"+answerList.get(0));
	    System.out.println("解説"+explanation1.get(0));
	    System.out.println("正誤判定"+ansCheck.get(0));
	    System.out.println("入れた回答"+answers.get(0));
	    
	    
	    
	    ArrayList<Ques> resultList = new ArrayList<Ques>();
	    for(int i = 0; i < numOfQuestions; i++) {
	    	Ques ques = new Ques(question1.get(i),option11.get(i),option21.get(i),option31.get(i),option41.get(i),
	    			answerList.get(i),explanation1.get(i),ansCheck.get(i),answers.get(i));
	    	System.out.println(question1.get(i));
	    	
	    	resultList.add(ques);
	    	
	    }
	    //正解率の算定
	    float accuracy = 0;
	    float counts=0;
	    for(int i = 0; i < numOfQuestions; i++) {
	    	
	    	if(ansCheck.get(i)) {
	    		counts++;
	    	}
	    	
	    }
		/*counts*=100;*/
	    accuracy = counts/numOfQuestions*100;
	    System.out.println(accuracy);
	    System.out.println(ansCheck.get(0));
	    
	    
		 //questionからanswerを取り出して配列に格納
			
	    request.setAttribute("resultList", resultList);
	    request.setAttribute("accuracy", accuracy);
	    
	    session.setAttribute("answers", answers);
	    session.setAttribute("ansCheck", ansCheck);
	    
	    request.getRequestDispatcher("/WEB-INF/jsp/scoring.jsp").forward(request, response);
	}

}
