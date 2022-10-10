package com.centimeAssignment.second.service.service.Impl;

import com.centimeAssignment.second.service.service.SecondService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SecondServiceImpl implements SecondService {

    @Override
    public String fetchHello() {
        log.info("secondController : fetching Hello World");
        return "Hello";
    }
}
