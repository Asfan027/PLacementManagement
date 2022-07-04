package com.placement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException
{
	private String resourceName;
	private String fieldName;
	private int fieldvalue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, int fieldvalue) {
		super(String.format("%s not found with %s : %d ",resourceName,fieldName,fieldvalue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}
	
	


}
