package com.placement.repo;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.placement.entity.PlacementEntity;
import com.placement.entity.TrainingEntity;
import com.placement.repository.CompanyRepository;
import com.placement.repository.PlacementRepository;
import com.placement.repository.TrainingRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlacementRepositoryTest
{
	@Autowired
	private PlacementRepository placementRepository;
	
	@Autowired
	private TrainingRepository trainingRepository;
	
	@Test
	@Order(1)
	public void savePlacementtest()
	{
		PlacementEntity placement=PlacementEntity.builder()
                                   .placementType("Java Developer")
                                   .placementDesc("Good Knowledge of Java Developer")
                                   .placementCompanyName("TCS").build();
		placementRepository.save(placement);
		Assertions.assertThat(placement.getPlacementId()).isGreaterThan(0);
		
	}
	@Test
	@Order(1)
	public void getPlacementById()
	{
		PlacementEntity placement=placementRepository.findById(101).get();
		Assertions.assertThat(placement.getPlacementId()).isGreaterThan(0);
	}
	@Test
	@Order(2)
	public void getPlacementList()
	{
		List<PlacementEntity> placement=this.placementRepository.findAll();
		Assertions.assertThat(placement.size()).isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void updatePlacement()
	{
		PlacementEntity placement=placementRepository.findById(102).get();
		placement.setPlacementCompanyName("TCS");
	    PlacementEntity placement1=placementRepository.save(placement);
		Assertions.assertThat(placement1.getPlacementCompanyName()).isEqualTo("TCS");
	}
	@Test
	@Order(5)
	public void deletePlacement()
	{
		 PlacementEntity placement = placementRepository.findById(102).get();
		 placementRepository.delete(placement);
		  PlacementEntity placement1=null;
		  Optional<PlacementEntity> optionalPlacement=placementRepository.findByplacementType("Data Science");
		  if(optionalPlacement.isPresent())
		  {
			  placement1 = optionalPlacement.get();
			  
		  }
		  Assertions.assertThat(placement1).isNull();
	}

	@Test
	@Order(6)
	public void getPlacementByTraining()
	{
		TrainingEntity training=trainingRepository.findById(102).get();
		List<PlacementEntity> placementList=placementRepository.findByTraining(training);
		Assertions.assertThat(placementList.size()).isGreaterThan(0);
	}

}
