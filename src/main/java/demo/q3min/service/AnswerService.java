package demo.q3min.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.q3min.repository.AnswerRepository;
import demo.q3min.vo.AnswerVo;

@Service
public class AnswerService {

	@Autowired
	AnswerRepository answerRepository;
	
	public void addAnswers(AnswerVo vo) {
		answerRepository.insert(vo);
	}
	
	public List<Map<String, String>> selectAnswers(String date) {
		return answerRepository.findAnswerByDate(date);
	}
	
	public void updateAnswer(Long id, String content) {
		answerRepository.updateContentByID(id, content);
	}
	
	public List<Map<String, String>> postQuestionAndAnswer(Long userID) {
		return answerRepository.findQuestionAndAnswerByUserID(userID);
	}
}
