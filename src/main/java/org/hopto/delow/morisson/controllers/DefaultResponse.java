package org.hopto.delow.morisson.controllers;

import lombok.Data;

import java.util.UUID;

@Data
public class DefaultResponse {

    private String id = UUID.randomUUID().toString();

    private String message = "Hello world";

}
