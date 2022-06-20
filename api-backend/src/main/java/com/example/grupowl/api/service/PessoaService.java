package com.example.grupowl.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.grupowl.api.model.Pessoa;
import com.example.grupowl.api.repository.PessoaRepository;

@Service
public class PessoaService {

	// ponto de injeção
	final PessoaRepository pessoaRepository;

	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	public void salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	public Object findAll() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas = pessoaRepository.findAllNativeQuery();
		return pessoas;		 
	}

	public Pessoa findBId(long id) {
		Pessoa pessoa = pessoaRepository.findIdNativeQuery(id);
		return pessoa;		
	}

	public Pessoa findById(long id) {		
		return pessoaRepository.findIdNativeQuery(id);
	}

	public void deleteById(long id) {
		pessoaRepository.deleteByIdNativeQuery(id);		
	}
	
	public Pessoa findCpf(Pessoa pessoa) {
		Pessoa obj = pessoaRepository.findCpfNativeQuery(pessoa.getCpf());
		return obj;		
	}

	public Object update(Object pessoa) {
		
		return null;
	}
	
	
}
