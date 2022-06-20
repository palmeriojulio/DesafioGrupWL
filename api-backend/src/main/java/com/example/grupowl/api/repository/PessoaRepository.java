package com.example.grupowl.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.grupowl.api.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	@Query(value = "SELECT * FROM pessoa", nativeQuery = true)
	List<Pessoa> findAllNativeQuery();
	
	@Query(value = "SELECT * FROM pessoa WHERE id = ?", nativeQuery = true)
	Pessoa findIdNativeQuery(Long id);
	
	@Query(value = "SELECT * FROM pessoa WHERE cpf = ?", nativeQuery = true)
	Pessoa findCpfNativeQuery(@Param("cpf") String cpf);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM pessoa WHERE id = ?1", nativeQuery = true) 
	void deleteByIdNativeQuery(@Param("id") long id);
	
	@Modifying
	@Query(value = "UPDATE pessoa SET nome = ?1, cpf = ?2, opcao = ?3 WEHRE ", nativeQuery = true)
	int updateNativeQuery(String nome, String cpf, String opcao);
	
}
