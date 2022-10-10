package com.centimeassignment.first.service.controller;

import com.centimeassignment.first.service.entity.DetailsEntity;
import com.centimeassignment.first.service.exception.InvalidJSONException;
import com.centimeassignment.first.service.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.centimeassignment.first.service.service.FirstService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/firstService")
@Slf4j
@ControllerAdvice
public class FirstController {

    @Autowired
    private FirstService firstService;

    @GetMapping("/get")
    public String getServerResponse () {

        log.info("firstController : fetching server response");
        return firstService.getServerResponse();

    }

    @GetMapping("/getDetails/{id}")
    public DetailsEntity getDetailsById(@PathVariable int id) {
        log.info("firstController : fetching details by id");
        return firstService.getDetailsbyId(id);
    }

    @GetMapping("/getDetails")
    public List<Map<String, Object>> getNestedResponse () {

        log.info("firstController : fetching all details");
        return firstService.getAllDetails();

    }

    @PostMapping("/postDetails")
    public List<DetailsEntity> postColors (@RequestBody List<DetailsEntity> jsonEntities) {

        log.info("firstController : posting data in table");
        try {
            return firstService.postDetails(jsonEntities);
        } catch (Exception e){
            log.info("The exception" + e);
            return null;
        }

    }

    @PostMapping("/postData")
    public String postData (@RequestBody User user) throws Exception {

        log.info("firstController : posting the user data");
        if (user.getName() == null || user.getSurName() == null) {
            throw  new InvalidJSONException("Not a valid JSON");
        }
        return firstService.concatenateStrings(user);

    }

}
