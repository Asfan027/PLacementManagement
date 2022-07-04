package com.placement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TrainingEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "train", initialValue = 101, sequenceName = "train")
//	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "train")

	private int trainingId;
	
	@Column(nullable = false)
	@NotEmpty(message="Name cannot be null")
	@Size(min=6,max=30)
	private String trainingName;
	
	@Column(nullable = false)
	@NotEmpty(message="Batch cannot be null")
	@Size(min=6,max=10)
	private String trainingBatch;
	
	@Column(nullable = false)
	private String trainingYear;
	
	@ManyToOne
	private CompanyEntity company;
	
	@OneToMany(cascade = CascadeType.ALL)

	private List<PlacementEntity> placementEntity = new ArrayList<PlacementEntity>();
	
	

}
