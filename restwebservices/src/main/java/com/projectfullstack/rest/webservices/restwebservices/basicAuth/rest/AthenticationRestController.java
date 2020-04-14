package com.projectfullstack.rest.webservices.restwebservices.basicAuth.rest;

import com.projectfullstack.rest.webservices.restwebservices.basicAuth.bean.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AthenticationRestController {

    @GetMapping("/basicauth")
    public AuthenticationBean helloWorldBean() {
        return new AuthenticationBean("You are athenticated");
    }
}
