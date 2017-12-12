package com.andersonlfeitosa.buildpipeline;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint responsável por exiber mensagem. 
 * 
 * @author Anderson Lobo Feitosa - andersonlf@gmail.com
 * @since 2017-12-11
 * @version 1.0.0
 */
@RestController
public class ApiController {

  /**
   * Expõe método HTTP GET para exibição de mensagem.
   *  
   * @return A mensagem.
   */
  @RequestMapping("/")
  public String sayHello() {
    return ("Hello World, this is a SpringBoot Microservice");
  }

}
