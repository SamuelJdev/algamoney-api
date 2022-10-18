package com.example.algamoney.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lancamento")
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull(message = "Campo Descrição é Obrigatório")
	private String descricao;

	@NotNull(message = "Campo Data Vencimento é Obrigatório")
	@Column(name = "data_vencimento")
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate dataVencimento;

	@Column(name = "data_pagamento")
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate dataPagamento;

	@NotNull(message = "Campo Valor é Obrigatório")
	private BigDecimal valor;

	@NotNull(message = "Campo Observação é Obrigatório")
	private String observacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipo;

	@NotNull(message = "Campo Categoria é Obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_categoria")
	private Categoria categoria;

	@NotNull(message = "Campo Pessoa é Obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_pessoa")
	private Pessoa pessoa;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
