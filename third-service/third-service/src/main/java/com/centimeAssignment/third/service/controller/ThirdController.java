package com.centimeAssignment.third.service.controller;

import com.centimeAssignment.third.service.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.centimeAssignment.third.service.service.ThirdService;


@RestController
@Slf4j
@RequestMapping("/thirdService")
public class ThirdController {

    @Autowired
    private ThirdService thirdService;

    @PostMapping("/post")
    public String concatenate(@RequestBody User user) {
        log.info("thirdController : posting user data");
        return thirdService.concatenateObject(user);
    }
}
