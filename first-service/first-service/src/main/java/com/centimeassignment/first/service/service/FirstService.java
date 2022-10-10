package com.centimeassignment.first.service.service;

import com.centimeassignment.first.service.entity.DetailsEntity;
import com.centimeassignment.first.service.model.User;

import java.util.List;
import java.util.Map;

public interface FirstService {

    String getServerResponse();
    String concatenateStrings(User user);

    List<Map<String, Object>> getAllDetails();

    List<DetailsEntity> postDetails(List<DetailsEntity> jsonEntities);

    DetailsEntity getDetailsbyId(int id);
}
