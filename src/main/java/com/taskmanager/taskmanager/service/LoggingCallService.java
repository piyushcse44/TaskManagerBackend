package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.model.LoggingCall;

import java.util.List;
import java.util.Optional;

public interface LoggingCallService {
    public List<LoggingCall> GetAll();
    public LoggingCall Get(Long logId);
    public LoggingCall CreateSingle(LoggingCall loggingCall);
    public LoggingCall CreateSingleWithId(Long id,LoggingCall loggingCall);
    public List<LoggingCall> CreateMultiple(List<LoggingCall> loggingCalls);
    public String Delete(Long id);
    public String DeleteAll();

}
