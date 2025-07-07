package com.example.Faculdade.dto;

import com.example.Faculdade.model.Curso;

public class CursoResponse {
	private Long id;
	private String nome;
	private String descricao;

	public CursoResponse(Curso c) {
		this.id = c.getId();
		this.descricao = c.getNome();
		this.nome = c.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
