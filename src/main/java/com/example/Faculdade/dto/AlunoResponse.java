package com.example.Faculdade.dto;

import com.example.Faculdade.model.Aluno;

public class AlunoResponse {
	private Long id;
	private String gmail;
	private String nome;
	private String nomeCurso; 
	
	public AlunoResponse() {}

	public AlunoResponse(Aluno aluno) {
		this.gmail=aluno.getGmail();
		this.nome=aluno.getNome();
		this.nomeCurso=aluno.getCurso().getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
}
