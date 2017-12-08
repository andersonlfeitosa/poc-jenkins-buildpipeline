package com.andersonlfeitosa.buildpipeline;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

  @RequestMapping("/")
  public String sayHello() {
    return ("Hello World, this is a SpringBoot Microservice");
  }

}
