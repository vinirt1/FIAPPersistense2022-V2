package br.com.fiap.persistense.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "S_CLIENTE", allocationSize = 1)
@Table(name = "cliente")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "tipo")
	private Integer tipo;

	@Column(name = "cpf_cnpj")
	private Long cpfCnpj;

	@Column(name = "nome")
	private String nome;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<Pedido> pedidos = new LinkedHashSet<Pedido>();

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<Endereco> enderecos = new LinkedHashSet<Endereco>();

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Long getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(Long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	// @Override
	// public String toString() {
	// return "Cliente [codigo=" + codigo + ", cpfCnpj=" + cpfCnpj + ", enderecos="
	// + enderecos + ", nome=" + nome
	// + ", pedidos=" + pedidos + ", tipo=" + tipo + "]";
	// }

}
