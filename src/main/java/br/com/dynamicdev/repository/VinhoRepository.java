package br.com.dynamicdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dynamicdev.model.Vinho;

public interface VinhoRepository extends JpaRepository<Vinho, Long>{

}
