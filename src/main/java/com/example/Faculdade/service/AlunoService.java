package com.example.Faculdade.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Faculdade.Repository.AlunoRepository;
import com.example.Faculdade.Repository.CursoRepository;
import com.example.Faculdade.dto.AlunoRequest;
import com.example.Faculdade.dto.AlunoResponse;
import com.example.Faculdade.model.Aluno;
import com.example.Faculdade.model.Curso;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	
	public AlunoResponse criar(AlunoRequest dto) {
		Curso curso = cursoRepository.findById(dto.getIdCurso())
				.orElseThrow(() -> new RuntimeException("Curso com ID " + dto.getIdCurso() + " não encontrado"));

		Aluno aluno = new Aluno();
		aluno.setNome(dto.getNome());
		aluno.setGmail(dto.getGmail());
		aluno.setCurso(curso);

		Aluno salvo = alunoRepository.save(aluno);
		return new AlunoResponse(salvo);
	}

	public AlunoResponse procurarId(Long id) {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Aluno com ID " + id + " não encontrado"));

		return new AlunoResponse(aluno);
	}

	public void deletarId(Long id) {
		if (!alunoRepository.existsById(id)) {
			throw new RuntimeException("Aluno com ID " + id + " não existe");
		}
		alunoRepository.deleteById(id);
	}

	public List<AlunoResponse> listar() {
		return alunoRepository.findAll().stream().map(AlunoResponse::new).collect(Collectors.toList());
	}

	public AlunoResponse atualizar(Long id, AlunoRequest dto) {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Aluno com ID " + id + " não encontrado"));

		Curso curso = cursoRepository.findById(dto.getIdCurso())
				.orElseThrow(() -> new RuntimeException("Curso com ID " + dto.getIdCurso() + " não encontrado"));

		aluno.setNome(dto.getNome());
		aluno.setGmail(dto.getGmail());
		aluno.setCurso(curso);

		Aluno atualizado = alunoRepository.save(aluno);
		return new AlunoResponse(atualizado);
	}
}
