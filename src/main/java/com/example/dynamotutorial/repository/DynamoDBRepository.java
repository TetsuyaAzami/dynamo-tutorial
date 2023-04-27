package com.example.dynamotutorial.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Component
public class DynamoDBRepository {

	final DynamoDbEnhancedClient client;

	@Autowired
	public DynamoDBRepository(DynamoDbEnhancedClient client) {
		//
		this.client = client;
	}

	public <T> void save(T record, Class<T> recordClass) {
		//
		String tableName = recordClass.getSimpleName();
		DynamoDbTable<T> table = client.table(tableName, TableSchema.fromBean(recordClass));
		table.putItem(record);
	}
}
