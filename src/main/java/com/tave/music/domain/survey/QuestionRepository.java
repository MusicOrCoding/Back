package com.tave.music.domain.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {

    private final EntityManager em;

    public void addQ(Question question){
        em.persist(question);
//        if (question.getId() == null) {
//            em.persist(question);
//        }
//        else {
//            em.merge(question);
//        }
    }

    public Question findOne(Long id) {
        return em.find(Question.class, id);
    }


    public List<Question> findBySurveyId(Long id) {
        return em.createQuery("select q from Question q where q.survey.getId() = :survey_id", Question.class)
                .setParameter("survey_id", id)
                .getResultList();
    }
//    public List<Question> findAll() {
//        return em.createQuery("select q from Question q", Question.class)
//                .getResultList();
//    }
}
