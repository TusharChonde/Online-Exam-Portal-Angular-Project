package com.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Answer;
import com.Entity.Question;
import com.Service.QuestionService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("http://localhost:4200")
public class QuestionController 
{

	@Autowired
	QuestionService questionService;
	
	@GetMapping("getAllAnswers")
	public Collection<Answer> getAllAnswers()
	{
		HttpSession httpsession=LoginController.httpsession;
			
		HashMap<Integer,Answer>  hashMap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
		
		// Collection   values()

		
			Collection<Answer>   collection=hashMap.values();
		
			return collection;
			
	}
	
//	@RequestMapping("getAllQuestions/{subject}")
//	public List<Question> getAllQuestions(@PathVariable String subject)
//	{
//		List<Question> list=questionService.getAllQuestions(subject);
//		HttpSession httpsession=LoginController.httpsession;
//		httpsession.setAttribute("allquestion",list);
//		
//		
//		
//		return list;
//	}

	@RequestMapping("getFirstQuestion/{subject}")
	public Question getFirstQuestion(@PathVariable String subject)
	{
		List<Question> list=questionService.getAllQuestions(subject);
		
		HttpSession httpsession=LoginController.httpsession;
		
		httpsession.setAttribute("allquestions",list);
	
		return list.get(0);
	}
	
//	@RequestMapping("nextQuestion")
//	public  Question nextQuestion()
//	{
//		HttpSession httpsession=LoginController.httpsession;
//		
//		List<Question> list=(List<Question>) httpsession.getAttribute("allquestions");
//		
//		//index=index+1;
//		
//		httpsession.setAttribute("questionIndex",(int)httpsession.getAttribute("questionIndex") + 1);//2
//		
//		Question question=list.get((int)httpsession.getAttribute("questionIndex"));
//				
//		return question;
//	}
		
		// 0 1 2
		@RequestMapping("nextQuestion")
		public  Question nextQuestion()
		{
			HttpSession httpsession=LoginController.httpsession;
			
			List<Question> list=(List<Question>) httpsession.getAttribute("allquestions");
			
			//index=index+1;
			
			
			Question question;
			
			if((int)httpsession.getAttribute("questionIndex")<list.size()-1)
			{

				httpsession.setAttribute("questionIndex",(int)httpsession.getAttribute("questionIndex") + 1);//2
				
				question=list.get((int)httpsession.getAttribute("questionIndex"));
						
			}
			else
				question=list.get(list.size()-1);// show last question
					
			return question;
			
		}

		
			// 0 1 2
			@RequestMapping("previousQuestion")
			public  Question previousQuestion()
			{
				HttpSession httpsession=LoginController.httpsession;
				
				List<Question> list=(List<Question>) httpsession.getAttribute("allquestions");
				
				Question question;
				
				if((int)httpsession.getAttribute("questionIndex")>0)
				{

					httpsession.setAttribute("questionIndex",(int)httpsession.getAttribute("questionIndex") - 1);//2
					
					question=list.get((int)httpsession.getAttribute("questionIndex"));
							
				}
				else
					question=list.get(0);// show first question
						
				return question;
				
			}
			
			// {"qno":1,"qtext":"why","submittedAnswer":"A","originalAnswer":"A"}
			
			@PostMapping("saveAnswer")
			public void saveAnswer(@RequestBody Answer answer)
			{
				System.out.println(answer);
				
				HttpSession httpsession=LoginController.httpsession;
				
				// add/update user response in HashMap
				
				if(answer.getSubmittedAnswer()!=null)
				{
					HashMap<Integer,Answer>   hashMap =  (HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
					hashMap.put(answer.getQno(),answer);
					System.out.println(hashMap);
				}
			
			}
			
			
//			@RequestMapping("endexam")
//			public ResponseEntity<Integer>  endexam()
//			{	
//
//				HttpSession httpsession=LoginController.httpsession;
//			
//				HashMap<Integer,Answer>  hashMap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
//				
//				// Collection   values()
//
//				Collection <Answer>  collection=hashMap.values();
//				
//				System.out.println(" values() gives object of class whose name is " + collection.getClass().getName());
//				
//				
//				// Collection collection=new ArrayList();
//				
//				// reference of interface can refer to object of implementation class
//				
//				
//				for (Answer ans : collection) 
//				{
//					if(ans.getSubmittedAnswer().equals(ans.getOriginalAnswer()))
//					{
//						httpsession.setAttribute("score",(int)httpsession.getAttribute("score")+1);//2
//						
//						// httpsession.setAttribute("score",10);
//						
//					}
//				}
//				
//
//				Integer score=(Integer)httpsession.getAttribute("score");
//				
//				System.out.println("Total Score at Server " + score);
//
//				ResponseEntity<Integer> responseEntity=new ResponseEntity<Integer>(score,HttpStatus.OK);
//
//				return responseEntity;
//				
//			}
//		
//	}
			@RequestMapping("endexam")
			public ResponseEntity<Integer>  endexam()
			{	

				HttpSession httpsession=LoginController.httpsession;
				
				try
				{
					HashMap<Integer,Answer>  hashMap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
				
				// Collection   values()
				
				
					Collection<Answer>   collection=hashMap.values();
				
					System.out.println(" values() gives object of class whose name is " + collection.getClass().getName());
				
				
				// Collection collection=new ArrayList();
				
				// reference of interface can refer to object of implementation class
				
				
				for (Answer ans : collection) 
				{
					if(ans.getSubmittedAnswer().equals(ans.getOriginalAnswer()))
					{
						httpsession.setAttribute("score",(int)httpsession.getAttribute("score")+1);//2
						
						// httpsession.setAttribute("score",10);
						
					}
				}
				

				Integer score=(Integer)httpsession.getAttribute("score");
				
				System.out.println("Total Score at Server " + score);

				httpsession.invalidate();// all attributes from HttpSession will be removed 
				
				ResponseEntity<Integer> responseEntity=new ResponseEntity<Integer>(score,HttpStatus.OK);

				return responseEntity;

				}
				
				catch(Exception e)
				{
					return null;
				}
			}
			
	}

