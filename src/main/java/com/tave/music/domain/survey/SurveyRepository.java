package com.tave.music.domain.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class SurveyRepository{

    private final EntityManager em;

    public void save(Survey survey){
        em.persist(survey);
    }

    public Survey findOne(Long id) {
        return em.find(Survey.class, id);
    }

    public List<Survey> findAll() {
        return em.createQuery("select s from Survey s", Survey.class).getResultList();
    }

    public List<Survey> findByTitle(String title){
        return em.createQuery("select s from Survey s where s.title = :title", Survey.class)
                .setParameter("title", title)
                .getResultList();
    }

    public List<Survey> findByUserId(Long id) {
        return em.createQuery("select s from Survey s where s.user.getId() = :user_id", Survey.class)
                .setParameter("user_id", id)
                .getResultList();
    }



//    List<Survey> findByTitle(String title);
//
//    //개인 설문조사만 조회
//    @Query("SELECT s FROM Survey s WHERE s.is_team = 0 ORDER BY s.id DESC")
//    List<Survey> findAllDesc();

}
