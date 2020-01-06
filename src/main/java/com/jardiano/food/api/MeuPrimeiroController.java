package com.jardiano.food.api;

import com.jardiano.food.api.domain.model.Cozinha;
import com.jardiano.food.api.jpa.CadastroCozinha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MeuPrimeiroController {

	private CadastroCozinha cadastroCozinha;
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {

		List<Cozinha> cozinhas = cadastroCozinha.listar();

		for (Cozinha cozinha : cozinhas) {
			System.out.println(cozinha.getNome());
		}
		return "Deu certo!";
	}
	
}
