package com.jessikafujimura.cliente;

public class Cliente {

    private Long id;

    private String nome;

    private Cliente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Cliente of(long id, String nome){
        return new Cliente(id, nome);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
