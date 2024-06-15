package br.simple.spring.simpleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleprojectApplication.class, args);
	}

	// http://localhost:8080/ola
	@GetMapping("/ola")
	public String ola(@RequestParam(value = "nome", defaultValue = "Mundo") String nome) {
		return String.format("<span style=\"color:purple; font-size:30px;\">Olá %s!</span>", nome);
	}

	// http://localhost:8080/inicio
	@GetMapping("/inicio")
    public String inicio() {
        return "index";
    }

	// http://localhost:8080/
	@GetMapping("/**")
	public String fallback() {
		return String.format("<span style=\"color:red; font-size:30px;\">404 Página não encontrada!</span>");
	}

}
