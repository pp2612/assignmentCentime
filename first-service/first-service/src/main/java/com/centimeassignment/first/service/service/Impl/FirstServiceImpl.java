package com.centimeassignment.first.service.service.Impl;

import com.centimeassignment.first.service.entity.DetailsEntity;
import com.centimeassignment.first.service.annotation.LogMethodParam;
import com.centimeassignment.first.service.model.User;
import com.centimeassignment.first.service.respository.DetailsRepository;
import com.centimeassignment.first.service.service.FirstService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Slf4j
public class FirstServiceImpl implements FirstService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DetailsRepository detailsRepository;

    @Value("${second.service}")
    String secondServiceUrl;
    @Value("${third.service}")
    String thirdServiceUrl;
    @Override
    public String getServerResponse() {

        log.info("firstService : fetching UP");
        return "Up";

    }

    @Override
    @LogMethodParam
    public String concatenateStrings(User jsonMap) {

        log.info("firstService : concatenatingString");
        String helloString = restTemplate.getForObject(secondServiceUrl, String.class);
        String concatenatedString = restTemplate.postForObject(thirdServiceUrl, jsonMap, String.class);
        return helloString + " " + concatenatedString;

    }

    @LogMethodParam
    public Map<String, Object> createNestedObject(DetailsEntity detailsEntity, Map<Integer,
            DetailsEntity> rowIdMap, Map<Integer, Boolean> visited, Map<Integer, List<Integer>> mapData, List<Integer> parentKeys) {

        log.info("firstService : creating nested object");
        Map<String, Object> parent= new LinkedHashMap<>();
        parent.put("Name", detailsEntity.getName());
        visited.put(detailsEntity.getId(), true);
        List<Map<String, Object>> childList = new ArrayList<>();
        if (parentKeys.contains(detailsEntity.getId())) {
            for (Integer child : mapData.get(detailsEntity.getId())) {
                if (!visited.get(child)) {
                    DetailsEntity childDetails = rowIdMap.get(child);
                    Map<String, Object> details1 = createNestedObject(childDetails, rowIdMap, visited, mapData, parentKeys);
                    childList.add(details1);
                }
            }
            if (childList.size() > 0) {
                parent.put("SubClasses", childList);
            }
        }
        return parent;

    }

    @LogMethodParam
    public List<Map<String, Object>> getAllDetails() {

        log.info("firstService : fetching all details");
        List<DetailsEntity> detailsEntityList = detailsRepository.findAll();
        Map<Integer, List<Integer>> mapData = new LinkedHashMap<>();
        Map<Integer, DetailsEntity> rowIdMap = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        for (DetailsEntity details : detailsEntityList) {
            visited.put(details.getId(), false);
            rowIdMap.put(details.getId(), details);
            if (details.getParentId() >= mapData.size()) {
                List<Integer> innerDetails = new ArrayList<>();
                innerDetails.add(details.getId());
                mapData.put(details.getParentId(), innerDetails);
            } else {
                mapData.get(details.getParentId()).add(details.getId());
            }
        }
        List<Integer> parentKeys = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> pair : mapData.entrySet()) {
            parentKeys.add(pair.getKey());
        }
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (DetailsEntity details : detailsEntityList) {
            if (!visited.get(details.getId())){
                resultList.add(createNestedObject(details, rowIdMap, visited, mapData, parentKeys));
            }
        }
        return resultList;

    }

    @LogMethodParam
    @Override
    public List<DetailsEntity> postDetails(List<DetailsEntity> jsonEntities) {

        log.info("firstService : posting details");
        return detailsRepository.saveAll(jsonEntities);

    }

    @LogMethodParam
    @Override
    public DetailsEntity getDetailsbyId(int id) {

        log.info("firstService : get details by id");
        Optional<DetailsEntity> jsonEntityOptional = detailsRepository.findById(id);
        return jsonEntityOptional.get();

    }
}
