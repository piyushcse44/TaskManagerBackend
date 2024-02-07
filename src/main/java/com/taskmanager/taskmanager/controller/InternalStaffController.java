package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.service.InternalStaffService;
import com.taskmanager.taskmanager.model.InternalStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/internal_staff")
public class InternalStaffController {
    @Autowired
    private final InternalStaffService internalStaffService;

    @Autowired
    public InternalStaffController(InternalStaffService internalStaffService)
    {
        this.internalStaffService = internalStaffService;
    }

    @GetMapping
    public List<InternalStaff> GetAllInternalStaff()
    {
        return internalStaffService.GetAll();
    }
    @GetMapping(path = "{id}")
    public InternalStaff GetInternalStaff(@PathVariable Long id )
    {
        return internalStaffService.Get(id);
    }

    @PostMapping
    public InternalStaff CreateInternalStaff(@RequestBody InternalStaff internalStaff)
    {
        return internalStaffService.CreateSingle(internalStaff);
    }

    @PutMapping(path = "{id}")
    public String UpdateInternalStaff(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    )
    {
        return internalStaffService.Update(id,name,email);
    }


}
