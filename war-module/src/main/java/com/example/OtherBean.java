package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherBean {

    @Autowired
    private SampleService service;

    public String test() {
        return "OtherBean: test [" + service.testService() + "]";
    }
}
