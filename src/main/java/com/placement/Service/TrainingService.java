package com.placement.service;

import java.util.List;

import com.placement.payloads.TrainingDto;

public interface TrainingService 
{
	public TrainingDto createTraining(TrainingDto trainingDto,int companyId);
	
	
	public TrainingDto getTrainingById(int trainingId);
	
	public List<TrainingDto> getAllTrainings();
	
	public TrainingDto updateTrainingById(TrainingDto trainingDto,int trainingId);
	
	public void deleteTrainingById(int trainingId);
	
	public List<TrainingDto> getAllTrainingsByCompany(int companyId);

}
