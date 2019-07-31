package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.DemoMapper;

@Service
@Transactional
public class DemoService {

    @Autowired
    private DemoMapper mapper;
    
    public String id() {
        return mapper.getId();
    }
    
}
