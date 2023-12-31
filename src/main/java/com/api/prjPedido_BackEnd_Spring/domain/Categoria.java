package com.api.prjPedido_BackEnd_Spring.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Categoria implements Serializable{
    @Serial
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    //Associações  categoria x produto *.*
    @JsonManagedReference
    @ManyToMany(mappedBy="categorias")
    private List<Produto> produtos = new ArrayList<>();

    //Construtores
    public Categoria(){
    }
    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    //Geters x Seters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Categoria categoria))
            return false;
        return Objects.equals(getId(), categoria.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
