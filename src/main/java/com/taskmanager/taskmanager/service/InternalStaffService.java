package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.model.InternalStaff;


import java.util.List;

public interface InternalStaffService {
    public List<InternalStaff> GetAll();
    public InternalStaff Get(Long id);
    public InternalStaff CreateSingle(InternalStaff internalStaff);
    public List<InternalStaff> CreateMultiple(List<InternalStaff> internalStaff);
    public String Delete(Long id);
    public String Update(Long id,String name,String email);
    public String DeleteAll();
}
