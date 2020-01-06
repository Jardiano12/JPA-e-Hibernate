package com.jardiano.food.api.jpa;

import com.jardiano.food.api.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;


@Component
public class CadastroCozinha {

	@PersistenceContext
	private EntityManager manager;

	//Lista objetos do banco de dados
	public List<Cozinha> listar() {
		return manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();
	}

	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}

	@Transactional
	public  Cozinha adicionar(Cozinha cozinha){
		return  manager.merge(cozinha);
	}

	//Trasação
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}

	//Trasação
	@Transactional
	public void remover(Cozinha cozinha) {
		cozinha = buscar(cozinha.getId());
		manager.remove(cozinha);
	}
}
