package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.model.LoggingCall;
import com.taskmanager.taskmanager.service.LoggingCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/logging_call")
public class LoggingCallController {
    @Autowired
    private final LoggingCallService loggingCallService;

    @Autowired
    public LoggingCallController(LoggingCallService loggingCallService) {
        this.loggingCallService = loggingCallService;
    }

    @GetMapping
    public List<LoggingCall> GetAllLoggingCallDetails()
    {
        return loggingCallService.GetAll();
    }

    @GetMapping(path = "{logId}")
    public LoggingCall GetLoggingCallDetail(@PathVariable Long logId)
    {
        return loggingCallService.Get(logId);
    }

    @PostMapping
    public LoggingCall CreateLoggingCallDetail(@RequestBody LoggingCall loggingCall)
    {
        return loggingCallService.CreateSingle(loggingCall);
    }

    @PostMapping(path = "{id}")
    public LoggingCall CreateLoggingCallDetailId(@PathVariable Long id,@RequestBody LoggingCall loggingCall)
    {
        return loggingCallService.CreateSingleWithId(id,loggingCall);
    }

    @DeleteMapping
    public String DeleteAllLoggingCallDetails()
    {
        return loggingCallService.DeleteAll();
    }

    @DeleteMapping(path = "{logId}")
    public String DeleteLoggingCallDetail(@PathVariable Long logId)
    {
        return loggingCallService.Delete(logId);
    }
}
