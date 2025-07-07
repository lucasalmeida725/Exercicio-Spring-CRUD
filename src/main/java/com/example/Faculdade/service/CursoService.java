package com.example.Faculdade.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Faculdade.Repository.CursoRepository;
import com.example.Faculdade.dto.CursoRequestDto;
import com.example.Faculdade.dto.CursoResponse;
import com.example.Faculdade.model.Curso;

@Service
public class CursoService {

	private final CursoRepository repository;

	public CursoService(CursoRepository repository) {
		this.repository = repository;
	}

	public CursoResponse Criar(CursoRequestDto dto) {
		Curso curso = new Curso();
		curso.setNome(dto.getNome());
		curso.setNome(dto.getNome());
		Curso salvar = repository.save(curso);
		return new CursoResponse(salvar);
	}

	public List<CursoResponse> Listar() {
		List<Curso> curso = repository.findAll();
		return curso.stream().map(CursoResponse::new).collect(Collectors.toList());
	}

	public void Deletar(Long id) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("Curso com: " + id + " não existe");
		}
		repository.deleteById(id);

	}

	public CursoResponse Procurar(Long id) {
		Curso curso = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Curso com: " + id + " não encontrado"));
		return new CursoResponse(curso);
	}

	public CursoResponse Atualizar(Long id, CursoRequestDto dto) {

		Curso curso = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Curso com" + id + "não encontrado"));

		curso.setDescricao(dto.getDescricao());
		curso.setNome(dto.getNome());

		Curso atualizar = repository.save(curso);
		return new CursoResponse(atualizar);

	}
}
