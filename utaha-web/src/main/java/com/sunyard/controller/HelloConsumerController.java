package com.sunyard.controller;

import com.sunyard.dto.UserDTO;
import com.sunyard.service.ICloudHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Churry
 * @create 2017-10-25 16:47
 **/
@RestController
public class HelloConsumerController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ICloudHelloService iCloudHelloService;

    @RequestMapping(value = "/hello-consumer", method = RequestMethod.GET)
    public Object HelloWorld () {
        return restTemplate.getForEntity("http://ERIRI/hello", String.class).getBody();
    }

    @RequestMapping(value = "/hello-myself", method = RequestMethod.GET)
    public UserDTO HelloMyself() {
       return iCloudHelloService.HelloMyself("Kasugaoka utaha", 17);
    }
}
