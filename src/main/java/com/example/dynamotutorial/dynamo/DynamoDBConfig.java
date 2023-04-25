package com.example.dynamotutorial.dynamo;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.example.dynamotutorial.repository")
public class DynamoDBConfig {
	BasicAWSCredentials awsCreds = new BasicAWSCredentials("dummy-access-key", "dummy-secret-key");

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
						"http://172.17.0.3:8000", "ap-northeast-1"))
				.build();
	}
}
