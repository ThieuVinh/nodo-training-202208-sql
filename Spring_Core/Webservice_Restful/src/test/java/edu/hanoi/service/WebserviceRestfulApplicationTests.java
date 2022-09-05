package edu.hanoi.service;

import edu.hanoi.service.model.Group;
import edu.hanoi.service.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
class WebserviceRestfulApplicationTests {

    private RestTemplate restTemplate;

    @Test
    void contextLoads() {
        restTemplate = new RestTemplate();
        String address = "http://localhost:8080/list/users";
        ResponseEntity<List> entity = restTemplate.getForEntity(address, List.class);
        List<User> users = entity.getBody();
    }

    @Test
    void contextLoads2() {
        restTemplate = new RestTemplate();
        String address = "http://localhost:8080/list/groups";
        ResponseEntity<Group[]> groupEntity = restTemplate.getForEntity(address, Group[].class);
        Group[] groups = groupEntity.getBody();
        Assert.assertTrue(groups.length > 0);

        for (int i = 0; i < groups.length; i++) {
            System.out.println(groups[i].getId());
        }
    }

    @Test
    void contextLoads3() {
        restTemplate = new RestTemplate();

        User user  = new User();
        user.setUsername("test1");
        user.setPassword("123");
        user.setEmail("test1@gmail.com");
        user.setAge(25);
        user.setGroupId(4);

        String address = "http://localhost:8080/add/user";
        ResponseEntity<String> insertEntity = restTemplate.postForEntity(address, user, String.class);
        Assert.assertEquals(user.getUsername(), insertEntity.getBody());
    }

    @Test
    void contextLoads4() {
        restTemplate = new RestTemplate();
        String address = "http://localhost:8080/get/user/test1";
        ResponseEntity<User> getEntity = restTemplate.getForEntity(address, User.class);
        Assert.assertEquals("123", getEntity.getBody().getPassword());
    }

    @Test
    void contextLoads5() {
        restTemplate = new RestTemplate();
        String address = "http://localhost:8080/delete/user/test1";
        ResponseEntity<Void> delEntity = restTemplate.getForEntity(address, Void.class);

        String address2 = "http://localhost:8080/get/user/test1";
        ResponseEntity<User> getEntity = restTemplate.getForEntity(address2, User.class);
        Assert.assertEquals(null, getEntity.getBody());
    }

    @Test
    void contextLoads6() {
        restTemplate = new RestTemplate();
        String address = "http://localhost:8080/get/user/user1";
        ResponseEntity<User> getEntity = restTemplate.getForEntity(address, User.class);
        User user = getEntity.getBody();
        Assert.assertNotNull(user);

        user.setPassword("321123");
        String address2 = "http://localhost:8080/update/user";
        ResponseEntity<Void> voidEntity = restTemplate.postForEntity(address, user, Void.class);

        String address3 = "http://localhost:8080/get/user/user1";
        ResponseEntity<User> getEntity2 = restTemplate.getForEntity(address3, User.class);
        Assert.assertEquals(user.getPassword(), getEntity2.getBody().getPassword());

    }
}
