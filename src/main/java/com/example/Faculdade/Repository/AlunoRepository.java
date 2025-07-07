package com.example.Faculdade.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Faculdade.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
