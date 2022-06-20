package com.example.grupowl.api.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.grupowl.api.model.Pessoa;
import com.example.grupowl.api.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	final PessoaService pessoaService;

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@PostMapping
	public ResponseEntity<Object> createPessoa(@RequestBody Pessoa pessoa) {
		
		Object pessoaFind = pessoaService.findCpf(pessoa);
		
		if (pessoaFind != null ) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: cpf digitado já está em uso!");
		} else {
			pessoaService.salvar(pessoa);
			return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
		}

	}

	@GetMapping
	public ResponseEntity<Object> getAllPessoa() {
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOnePessoa(@PathVariable(value = "id") long id) {
		Optional<Pessoa> pessoa = Optional.ofNullable(pessoaService.findById(id));

		if (!pessoa.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NÃO EXISTE");
			
		} else {
			return new ResponseEntity<Object>(pessoa.get(), HttpStatus.OK);
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePessoa(@PathVariable(value = "id") long id) {
		
		Optional<Pessoa> pessoa = Optional.ofNullable(pessoaService.findById(id));
				
		if (!pessoa.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
			
		} else {
			pessoaService.deleteById(pessoa.get().getId());
			return new ResponseEntity<Object>(pessoa.get(), HttpStatus.OK);
		}

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePessoa(@PathVariable(value = "id") long id, @RequestBody Pessoa pesssoa) {
			
		Optional<Pessoa> pessoaOld = Optional.ofNullable(pessoaService.findById(id));
		
		if (!pessoaOld.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
		} 
		
		var pessoa = pessoaOld.get();
		
		pessoa.setNome(pessoa.getNome());
		pessoa.setNome(pessoa.getCpf());
		pessoa.setNome(pessoa.getOpcao());
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoaService.update(pesssoa));
	}

}

