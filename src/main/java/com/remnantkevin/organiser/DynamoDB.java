package com.remnantkevin.organiser;

import java.util.stream.Collectors;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.List;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.*;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;


public class DynamoDB {

    private final DynamoDbClient client;

    public DynamoDB() {
        AwsCredentialsProvider creds = DefaultCredentialsProvider.create();
        client = DynamoDbClient.builder()
            .credentialsProvider(creds)
            .region(Region.US_EAST_1)
            .build();
    }

    public List<Note> getAllNotes() {
        ScanRequest scanRequest = ScanRequest.builder()
            .tableName("remnant-kevin-organiser")
            .build();
        
        ScanResponse scanResponse = client.scan(scanRequest);

        return scanResponse.items()
            .stream()
            .map(this::getNote)
            .collect(Collectors.toList());
    }

    private Note getNote(Map<String, AttributeValue> item) {
        String title = item.get("title").s();
        String content = item.get("content").s();
        Long createdAt = Long.parseLong(item.get("createdAt").n());
        Long archivedAt = Long.parseLong(item.get("archivedAt").n());

        return new Note(title, content, createdAt, archivedAt);
    }

    public void setNote(Note note) {
        Map<String, AttributeValue> item = null;
        client.putItem(builder -> builder.tableName("remnant-kevin-organiser").item(item));
    }


}