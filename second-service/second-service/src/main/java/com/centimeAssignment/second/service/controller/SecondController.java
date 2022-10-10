package com.centimeAssignment.second.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.centimeAssignment.second.service.service.SecondService;

@Slf4j
@RestController
@RequestMapping("/secondService")
public class SecondController {

    @Autowired
    private SecondService secondService;

    @GetMapping("/get")
    public ResponseEntity<String> getHelloWorld() {
        log.info("secondController : fetching Hello World");
        String hw = secondService.fetchHello();
        return new ResponseEntity<String>(hw, HttpStatus.OK);
    }
}


