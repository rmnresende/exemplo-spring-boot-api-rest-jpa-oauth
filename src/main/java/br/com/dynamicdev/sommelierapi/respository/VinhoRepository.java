package br.com.dynamicdev.sommelierapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dynamicdev.sommelierapi.model.Vinho;

public interface VinhoRepository extends JpaRepository<Vinho, Long>{

}
