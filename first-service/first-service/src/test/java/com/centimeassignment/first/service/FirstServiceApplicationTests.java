package com.centimeassignment.first.service;

import com.centimeassignment.first.service.entity.DetailsEntity;
import com.centimeassignment.first.service.model.User;
import com.centimeassignment.first.service.respository.DetailsRepository;
import com.centimeassignment.first.service.service.Impl.FirstServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FirstServiceApplicationTests {


	@InjectMocks
	private FirstServiceImpl firstServiceImpl;

	@Mock
	private DetailsRepository detailsRepository;

	@Mock
	private RestTemplate restTemplate;

	@Test
	public void testPostDetails () {

		DetailsEntity detailsEntity1 = new DetailsEntity();
		detailsEntity1.setName("Warrior");
		detailsEntity1.setColor("red");
		detailsEntity1.setId(1);
		detailsEntity1.setParentId(0);
		DetailsEntity detailsEntity2 = new DetailsEntity();
		detailsEntity2.setName("Wizard");
		detailsEntity2.setColor("green");
		detailsEntity2.setId(2);
		detailsEntity2.setParentId(0);
		List<DetailsEntity> detailsEntityList = new ArrayList<>();
		detailsEntityList.add(detailsEntity1);
		detailsEntityList.add(detailsEntity2);

		Mockito.when(detailsRepository.saveAll(detailsEntityList)).thenReturn(detailsEntityList);
		List<DetailsEntity> actualResult = firstServiceImpl.postDetails(detailsEntityList);
		assertEquals(detailsEntityList, actualResult);

	}

	@Test
	public void testGetDetailsById () {
		DetailsEntity detailsEntity1 = new DetailsEntity();
		detailsEntity1.setName("Warrior");
		detailsEntity1.setColor("red");
		detailsEntity1.setId(1);
		detailsEntity1.setParentId(0);
		Mockito.when(detailsRepository.findById(1)).thenReturn(Optional.of(detailsEntity1));
		DetailsEntity actualResult = firstServiceImpl.getDetailsbyId(1);
		assertEquals(detailsEntity1.getName(), actualResult.getName());
	}

}
