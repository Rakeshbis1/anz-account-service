/**
 * This API developed for ANZ and managed by Cognizant
 */
/**
 * @author Rakesh
 *
 */
package com.anz.api.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AnzAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnzAccountServiceApplication.class, args);
	}

}
