package com.taskmanager.taskmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(path = "/api")
public class ApiController {

    @GetMapping
    public Map<String,String> ApiDetails()
    {
        Map<String,String> apiDetails = new HashMap<>() ;
        apiDetails.put("Get /api","Show api details");
        apiDetails.put("Get /api/user","Get All User Details");
        apiDetails.put("Get /api/user/{userId}","Get Detail of user having id userId");
        apiDetails.put("POST /api/user","create new User Details");
        apiDetails.put("Delete /api/user","Delete All User Details");
        apiDetails.put("Delete  /api/user/{id}","Delete User Details of id : id");
        apiDetails.put("Get /api/internal_staff","Get All internal staff Details");
        apiDetails.put("POST /api/internal_staff","create new internal staff Details");
        apiDetails.put("Delete /api/internal_staff","Delete All internal staff Details");
        apiDetails.put("Delete  /api/internal_staff","Delete  Details of id : id");
        apiDetails.put("Get  /api/logging_call","Get All Logging call Details");
        apiDetails.put("Post  /api/logging_call","Create logging_call");
        apiDetails.put("Post  /api/logging_call/{userid}","Create logging_call of a user ");
        apiDetails.put("Delete  /api/logging_call","Delete All logging_call");
        apiDetails.put("Delete  /api/logging_call/{id}","Delete  logging_call with id:id");
        return apiDetails;



    }
}
