package com.andersonlfeitosa.buildpipeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal do app. 
 * Responsável por carregar a aplicação.
 * 
 * @author Anderson Lobo Feitosa - andersonlf@gmail.com
 * @since 2017-12-11
 * @version 1.0.0
 */
@SpringBootApplication
public class Application {

  /**
   * Método principal da classe e responsável pela execução da aplicação.
   * 
   * @param args A lista dos parâmetros para execução da aplicação.
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
