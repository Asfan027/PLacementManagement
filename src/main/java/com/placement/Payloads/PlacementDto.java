package com.placement.payloads;

import com.placement.entity.TrainingEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlacementDto 
{
    private int placementId;
	
	private String placementType;
	
	private String placementDesc;
	
	private String placementCompanyName;
	
	private TrainingEntity training; 

}
