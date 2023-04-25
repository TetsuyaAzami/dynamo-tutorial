package com.example.dynamotutorial.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "users")
public class User {

	@DynamoDBHashKey
	String id;

	@DynamoDBAttribute
	String firstName;

	@DynamoDBAttribute
	String lastName;
}
