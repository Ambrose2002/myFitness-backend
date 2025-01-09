package com.ambrose.myFitness;

import com.amazonaws.services.s3.AmazonS3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class S3IntegrationTest {

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${s3.bucket.name}")
    private String bucketName;

    @Test
    public void testS3Connection() {
        // List objects in the S3 bucket
        assertTrue(amazonS3.doesBucketExistV2(bucketName), "Bucket should exist");
    }

    @Test
    public void testUploadFile() {
        // Upload a file to the S3 bucket
        String fileName = "test-upload.txt";
        amazonS3.putObject(bucketName, fileName, "This is a test file.");
        assertTrue(amazonS3.doesObjectExist(bucketName, fileName), "File should be uploaded");
    }
}