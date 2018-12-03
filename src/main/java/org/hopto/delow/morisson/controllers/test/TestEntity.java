package org.hopto.delow.morisson.controllers.test;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class TestEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String email;

}
