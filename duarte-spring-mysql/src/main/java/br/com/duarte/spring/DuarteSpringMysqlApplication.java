package br.com.duarte.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="br.com.duarte.spring.repository")
public class DuarteSpringMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DuarteSpringMysqlApplication.class, args);
	}

}
