package com.practice.random;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.iterable.S3Versions;
import com.amazonaws.services.s3.model.S3VersionSummary;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        deleteBucket("test-del");
    }

    public static boolean is2SumPossible(List<Integer> list, int sum) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i: list) {
         if(map.containsKey(i))
             return true;
         map.put(sum - i, true);
        }
        return false;
    }


    private static void deleteBucket(String bucketName) {
        AmazonS3Client amazonClient;
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setProtocol(Protocol.HTTP);
        AWSCredentials credentials = new BasicAWSCredentials("JXE2DEB40MK8AP5CALXP", "cRdfjyodUOUMK9JAm7b3MmhoOxx9MViiNw6BRAiH");
        amazonClient = new AmazonS3Client(credentials, clientConfiguration);
        amazonClient.setEndpoint("http://10.47.2.22");
        amazonClient.setS3ClientOptions(new S3ClientOptions().withPathStyleAccess(true));

/*//Creates Bucket
        amazonClient.createBucket(bucketName);

//Enable Versioning
        BucketVersioningConfiguration configuration = new BucketVersioningConfiguration(ENABLED);
        amazonClient.setBucketVersioningConfiguration(new SetBucketVersioningConfigurationRequest(bucketName, configuration ));

//Puts versions
        amazonClient.putObject(bucketName, "some-key",new ByteArrayInputStream("some-bytes".getBytes()), null);
        amazonClient.putObject(bucketName, "some-key",new ByteArrayInputStream("other-bytes".getBytes()), null);*/

//Removes all versions
        for ( S3VersionSummary version : S3Versions.inBucket(amazonClient, bucketName) ) {
            String key = version.getKey();
            String versionId = version.getVersionId();
            System.out.println(key + " - " + versionId);
//            amazonClient.deleteVersion(bucketName, key, versionId);
        }

//Removes the bucket
//        amazonClient.deleteBucket(bucketName);
        System.out.println("Done!");
    }
}
