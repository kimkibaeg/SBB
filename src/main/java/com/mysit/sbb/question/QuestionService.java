package com.mysit.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service		// 빈등록 : 클래스를 객체화 해서 spring framework에 등록  
public class QuestionService {
	// controller ==> service ==> repository 
	
	private final QuestionRepository questionRepository; 
	
	// question테이블의 모든 레코드를 가져와서 리턴 
	// 리스트 페이지
	// 페이징 처리되지 않는 모든 레코드를 출력 
	public List<Question> getList () {
		return questionRepository.findAll(); 
	}
	
	//상세 페이지 
	public Question getQuestion(Integer id) {
		Optional<Question> op = 
				questionRepository.findById(id); 	
		return op.get(); 
	}
	
	// question 테이블에 값 insert 
	public void create(String subject, String content) {
		
		Question q = new Question(); 
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		
		questionRepository.save(q); 
		
	}
	
	// 요청할 페이지 번호를 매개변수로 입력 : 
	public Page<Question> getList(int page) {
		
		// page : 요청하는 페이지 번호, 10 : 한페이지에서 출력 하는 레코드 갯수 
		Pageable pageable = PageRequest.of(page, 10); 
					
		return questionRepository.findAll(pageable); 
	}
	

	

}