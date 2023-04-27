package com.example.dynamotutorial.dynamodbAwsSdk;

import java.net.URI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDBSdkConfig {

	private final String dynamoDBEndPointUrl;

	private final AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create("dummy-access-key", "dummy-secret-key");

	public DynamoDBSdkConfig() {
		this.dynamoDBEndPointUrl = "http://172.17.0.3:8000";
	}


	@Bean
	public DynamoDbClient getDynamoDbClient() {
		//
		return DynamoDbClient.builder().region(Region.US_EAST_1).endpointOverride(URI.create(dynamoDBEndPointUrl)).credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials)).build();
	}

	@Bean
	public DynamoDbEnhancedClient getDynamoDbEnhancedClient() {
		//
		return DynamoDbEnhancedClient.builder().dynamoDbClient(getDynamoDbClient()).build();
	}
}
