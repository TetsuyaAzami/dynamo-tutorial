package com.example.dynamotutorial.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@DynamoDbBean
public class SdkUser {

	@Getter(AccessLevel.NONE)
	String id;

	String firstName;

	String lastName;

	@DynamoDbPartitionKey
	public String getId() {
		return id;
	}
}
