package br.com.vidaMaterna.msusuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//Nome dos Integrates
// Luiz Antonio - 87005
// Henry Sato - 86776
// Cristian Rossmann - 87896
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MsUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUsuarioApplication.class, args);
	}
}
