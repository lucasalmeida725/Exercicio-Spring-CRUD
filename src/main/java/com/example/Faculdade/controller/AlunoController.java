package com.example.Faculdade.controller;

import java.util.List;

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

import com.example.Faculdade.dto.AlunoRequest;
import com.example.Faculdade.dto.AlunoResponse;
import com.example.Faculdade.service.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Aluno")
public class AlunoController {
	private final AlunoService service;

	public AlunoController(AlunoService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<AlunoResponse> Criar(@RequestBody @Valid AlunoRequest dto) {
		AlunoResponse response = service.criar(dto);
		return ResponseEntity.ok(HttpStatus.CREATED).ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AlunoResponse> ProcurarId(@PathVariable Long id) {
		AlunoResponse response = service.procurarId(id);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeletarId(@PathVariable Long id) {
		service.deletarId(id);
		return ResponseEntity.ok("Aluno deletado com sucesso");
	}

	@GetMapping
	public ResponseEntity<List<AlunoResponse>> Listar() {
		return ResponseEntity.ok(service.listar());
	}

	@PutMapping("/{id}")
	public ResponseEntity<AlunoResponse> Atualizar(@PathVariable Long id, @RequestBody @Valid AlunoRequest dto) {
		AlunoResponse response = service.atualizar(id, dto);
		return ResponseEntity.ok(response);
	}
}
