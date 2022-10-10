package com.centimeAssignment.third.service.service.Impl;

import com.centimeAssignment.third.service.model.User;
import com.centimeAssignment.third.service.service.ThirdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ThirdServiceImpl implements ThirdService {
    @Override
    public String concatenateObject(User user) {
        log.info("thirdService : concatenating objects");
        return user != null ? user.getName()   + " " + user.getSurName() : "";
    }
}
