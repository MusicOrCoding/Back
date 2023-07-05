package com.tave.music.service.survey;

import com.tave.music.domain.survey.Answer_option;
import com.tave.music.domain.survey.Answer_optionRepository;
import com.tave.music.domain.survey.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class Answer_optionService {

    private final Answer_optionRepository answer_optionRepository;
    private final QuestionRepository questionRepository;

    //답변 옵션 추가
    @Transactional
    public void addAnswerOption(Answer_option answer_option) {
        answer_optionRepository.addAnswerOption(answer_option);
    }

    //질문에 대응되는 답변 옵션 조회
    public List<Answer_option> findAnswerOptions(Long questionId) {
        return answer_optionRepository.findByQuestionId(questionId);
    }

    //개별 조회
    public Answer_option findOne(Long answer_option_id) {
        return answer_optionRepository.findOne(answer_option_id);
    }
}
