package demo.q3min.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kugods.project.exception.QuestionRepositoryException;
import com.kugods.project.vo.QuestionVo;

@Repository
public class QuestionRepository {

	@Autowired
	private SqlSession sqlSession;

	public void insert(List<QuestionVo> voList)  throws QuestionRepositoryException{
		
		for (QuestionVo vo : voList) {
			sqlSession.insert("question.insert", vo);
		}
	}

	
	
}
