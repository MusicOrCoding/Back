package com.tave.music.domain.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class Answer_optionRepository {
    private EntityManager em;

    public void addAnswerOption(Answer_option answer_option) {
        em.persist(answer_option);
    }

    public Answer_option findOne(Long id) {
        return em.find(Answer_option.class, id);
    }

    public List<Answer_option> findByQuestionId(Long id) {
        return em.createQuery("select a from ANSWER_OPTION a where a.question.getId() = :question_id", Answer_option.class)
                .setParameter("question_id", id)
                .getResultList();
    }
}
