package com.tave.music.domain.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    public void saveUser(User user){
        em.persist(user);
    }

    public User findOne(Long user_id) {
        return em.find(User.class, user_id);
    }
}
