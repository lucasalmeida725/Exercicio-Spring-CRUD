package com.example.Faculdade.dto;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.NotBlank;

public class AlunoRequest {

	@NotBlank(message = "Nome obrigatorio do aluno")
	private String nome;
	@NotBlank(message = "Email obrigatorio e valido")
	private String gmail;
	@NotNull
	private Long idCurso;

	public AlunoRequest() {
	}

	public AlunoRequest(String nome, String gmail, Long idCurso) {
		this.nome = nome;
		this.gmail = gmail;
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long id_Curso) {
		this.idCurso = id_Curso;
	}

}
