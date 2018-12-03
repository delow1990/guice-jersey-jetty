package org.hopto.delow.morisson.controllers.test;

import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class TestService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public void setTestEntity(TestRequest testRequest) {
        TestEntity testEntity = new TestEntity();
        testEntity.setEmail(testRequest.getEmail());
        entityManager.persist(testEntity);
        entityManager.flush();
    }

}
