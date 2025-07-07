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

import com.example.Faculdade.dto.CursoRequestDto;
import com.example.Faculdade.dto.CursoResponse;
import com.example.Faculdade.service.CursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Curso")
public class CursoController {

	private final CursoService service;

	public CursoController(CursoService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<CursoResponse> Criar(@RequestBody @Valid CursoRequestDto dto) {
		CursoResponse response = service.Criar(dto);
		ResponseEntity.ok(HttpStatus.CREATED);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CursoResponse> ProcurarId(Long id) {
		CursoResponse response = service.Procurar(id);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<List<CursoResponse>> Listar() {
		return ResponseEntity.ok(service.Listar());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> Remover(@PathVariable Long id) {
		service.Deletar(id);
		return ResponseEntity.ok("Curso deletado com sucesso");
	}

	@PutMapping("/{id}")
	public ResponseEntity<CursoResponse> Atualizar(@PathVariable Long id, @RequestBody @Valid CursoRequestDto dto) {
		CursoResponse response = service.Atualizar(id, dto);
		return ResponseEntity.ok(response);
	}
}
