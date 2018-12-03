package org.hopto.delow.morisson.controllers.test;

import org.hopto.delow.morisson.controllers.DefaultResponse;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestController {

    @Inject
    private EntityManager entityManager;

    @Inject
    private TestService testService;

    @POST
    public DefaultResponse response(@Valid TestRequest testRequest) {
        testService.setTestEntity(testRequest);
        return new DefaultResponse();
    }

    @GET
    public List<TestEntity> getEntities() {
        List<TestEntity> list = entityManager.createQuery("select t from TestEntity t").getResultList();
        return list;
    }

}
