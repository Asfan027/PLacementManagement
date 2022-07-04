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

import com.placement.entity.CompanyEntity;
import com.placement.entity.TrainingEntity;
import com.placement.repository.CompanyRepository;
import com.placement.repository.TrainingRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TrainingRepositoryTest
{

	
	@Autowired
	private TrainingRepository trainingRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Test
	@Order(1)
	public void saveTrainingtest()
	{
		 TrainingEntity training=TrainingEntity.builder()
                                 .trainingName("Java Developer")
                                 .trainingBatch("4th batch")
                                 .trainingYear("2021").build();
		trainingRepository.save(training);
		Assertions.assertThat(training.getTrainingId()).isGreaterThan(0);
		
	}
	@Test
	@Order(1)
	public void getTrainingById()
	{
		TrainingEntity training=trainingRepository.findById(101).get();
		Assertions.assertThat(training.getTrainingId()).isGreaterThan(0);
	}
	@Test
	@Order(2)
	public void getTrainingList()
	{
		List<TrainingEntity>training=this.trainingRepository.findAll();
		Assertions.assertThat(training.size()).isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void updateTraining()
	{
		TrainingEntity training=trainingRepository.findById(102).get();
		training.setTrainingName("Data Science");
		TrainingEntity training1=trainingRepository.save(training);
		Assertions.assertThat(training1.getTrainingName()).isEqualTo("Data Science");
	}
	@Test
	@Order(5)
	public void deleteTraining()
	{
		 TrainingEntity training = trainingRepository.findById(102).get();
		 trainingRepository.delete(training);
		  TrainingEntity training1=null;
		  Optional<TrainingEntity> optionaltraining=trainingRepository.findBytrainingBatch("IT");
		  if(optionaltraining.isPresent())
		  {
			  training1=optionaltraining.get();
			  
		  }
		  Assertions.assertThat(training1).isNull();
	}
	

	@Test
	@Order(6)
	public void getTrainingByCompanyId()
	{
		CompanyEntity company=companyRepository.findById(102).get();
		List<TrainingEntity> trainingList=trainingRepository.findByCompany(company);
		Assertions.assertThat(trainingList.size()).isGreaterThan(0);
	}
}
