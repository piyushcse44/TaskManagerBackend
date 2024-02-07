package com.taskmanager.taskmanager.service.impl;

import com.taskmanager.taskmanager.repository.InternalStaffRepository;
import com.taskmanager.taskmanager.service.InternalStaffService;
import com.taskmanager.taskmanager.model.InternalStaff;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InternalStaffServiceImp implements InternalStaffService {
    @Autowired
    private  final InternalStaffRepository internalStaffRepository;

    @Autowired
    public InternalStaffServiceImp(InternalStaffRepository internalStaffRepository) {
        this.internalStaffRepository = internalStaffRepository;
    }


    @Override
    public List<InternalStaff> GetAll() {
        List<InternalStaff> internalStaffs;
        internalStaffs = internalStaffRepository.findAll();
        return internalStaffs;
    }

    @Override
    public InternalStaff Get(Long id) {
        return internalStaffRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("internal staff not found with id: " + id));
    }

    @Override
    public InternalStaff CreateSingle(InternalStaff internalStaff) {
        System.out.println("ppppppppppppp");
        Optional<InternalStaff> internalStaff1 = internalStaffRepository.findByEmail(internalStaff.getEmail());
        if(internalStaff1.isPresent())
            throw new IllegalStateException("Internal staff with email "+internalStaff.getEmail()+" is already present");
        internalStaff.setCreated_on(LocalDateTime.now());
        internalStaffRepository.save(internalStaff);
        return internalStaff;

    }

    @Override
    public List<InternalStaff> CreateMultiple(List<InternalStaff> internalStaff) {
        return null;
    }

    @Override
    public String Delete(Long id) {
       if(internalStaffRepository.existsById(id))
       {
           internalStaffRepository.deleteById(id);
           return("Deleted SuccessFully");
       }
       throw new IllegalStateException("InternalStaff with id" + id + " is not present");

    }

    @Override
    @Transactional
    public String Update(Long id, String name, String email) {
        InternalStaff internalStaff = internalStaffRepository.findById(id).orElseThrow(
                ()->new IllegalStateException("Internal staff with "+id+" is not present")
        );
        if(name!=null && !name.isEmpty() && !name.equals(internalStaff.getName()) )
            internalStaff.setName(name);
        if(email!=null && !email.isEmpty() && !email.equals((internalStaff.getEmail())))
        {
            if(internalStaffRepository.findByEmail(email).isPresent())
            {
                throw new IllegalStateException("email "+ email +" is already present");
            }
            internalStaff.setEmail(email);
        }
        return ("Updated Successfully");

    }

    @Override
    public String DeleteAll() {
       internalStaffRepository.deleteAll();
       return "Deleted SuccessFully";
    }
}
