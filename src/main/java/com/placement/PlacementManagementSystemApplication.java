package com.placement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlacementManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlacementManagementSystemApplication.class, args);
	}

	@Bean
	ModelMapper getModelMapper()
	{
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

}
