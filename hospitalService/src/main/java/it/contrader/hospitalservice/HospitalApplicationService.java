package it.contrader.hospitalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HospitalApplicationService {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplicationService.class, args);
    }

}
