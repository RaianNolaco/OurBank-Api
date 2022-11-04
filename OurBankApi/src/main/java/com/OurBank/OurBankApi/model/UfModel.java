package com.OurBank.OurBankApi.model;

import javax.persistence.Entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_uf")
public class UfModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_uf")
	private Integer id;
	
	@Column(name = "estado", length = 25)
	private String estado;
	
	@Column(name = "sigla", length =2)
	private String sigla;
}
