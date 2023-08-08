package demo.q3min.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.q3min.repository.QuestionRepository;
import demo.q3min.vo.QuestionVo;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;
	
	public void addQuestion(List<QuestionVo> voList) {
		questionRepository.insert(voList);
	}
	
}
