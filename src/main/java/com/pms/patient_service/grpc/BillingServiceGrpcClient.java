package com.pms.patient_service.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class BillingServiceGrpcClient {
    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    public BillingServiceGrpcClient(
            @Value("${billing.service.address:billing-service}") String serverAddress,
            @Value("${billing.service.grpc.port:9001}") int serverPort) {

        log.info("Connecting to the billing service GRPC service at {}:{}", serverAddress, serverPort);
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(serverAddress, serverPort)
                .usePlaintext()
                .build();

        blockingStub = BillingServiceGrpc.newBlockingStub(channel);
    }

    public BillingResponse createBillingAccount(String patientId, String name, String email) {
        try {
            BillingRequest request = BillingRequest.newBuilder()
                    .setPatientId(patientId)
                    .setEmail(email)
                    .setName(name)
                    .build();

            log.info("Sending billing request for patientId: {}", patientId);
            BillingResponse response = blockingStub.createBillingAccount(request);
            log.info("Received response from the billing service via GRPC: {}", response);
            return response;
        } catch (Exception e) {
            log.error("Error calling billing service", e);
            throw new RuntimeException("Failed to create billing account", e);
        }
    }
}