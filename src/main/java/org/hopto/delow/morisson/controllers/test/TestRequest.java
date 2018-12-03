package org.hopto.delow.morisson.controllers.test;


import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

@Data
public class TestRequest {

    @NotNull
    private Integer id;

    @Email
    private String email;

}
