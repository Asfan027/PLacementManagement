package com.placement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.placement.entity.PlacementEntity;
import com.placement.entity.TrainingEntity;

public interface PlacementRepository extends JpaRepository<PlacementEntity, Integer>
{

	List<PlacementEntity> findByTraining(TrainingEntity trainingEntity);
	
@Query(value = "SELECT * FROM placement_entity plac WHERE plac.training_training_id = :placid",nativeQuery = true)
	
	public List<PlacementEntity> getPlacementEntityByPlacid( @Param("placid") int placid);

	Optional<PlacementEntity> findByplacementType(String placementtype);

}
