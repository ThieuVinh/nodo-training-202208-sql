package edu.hanoi.service.test;

import edu.hanoi.service.model.User;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(JUnit4.class)
public class SpringServiceClientTests {
    private RestTemplate restTemplate;


    @Test
    public void contextLoads() {
        restTemplate = new RestTemplate();
        String address = "http://localhost:8080/list/users";
        ResponseEntity<List> entity = restTemplate.getForEntity(address, List.class);
        List<User> users = entity.getBody();
    }
}
