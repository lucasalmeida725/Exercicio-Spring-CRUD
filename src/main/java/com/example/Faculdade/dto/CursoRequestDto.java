package com.example.Faculdade.dto;

import jakarta.validation.constraints.NotBlank;

public class CursoRequestDto {
	@NotBlank(message = "Nome é obrigatorio")
	private String nome;

	@NotBlank(message = "Descricao obrigatoria")
	private String descricao;

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

	
	
}
