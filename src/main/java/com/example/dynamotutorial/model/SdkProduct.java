package com.example.dynamotutorial.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Data
@DynamoDbBean
public class SdkProduct {

	@Getter(AccessLevel.NONE)
	String id;

	@Getter(AccessLevel.NONE)
	String category;

	String name;

	@DynamoDbPartitionKey
	public String getId() {
		return id;
	}

	@DynamoDbSortKey
	public String getCategory() {
		return category;
	}
}
