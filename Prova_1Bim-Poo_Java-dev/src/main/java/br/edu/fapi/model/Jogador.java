package br.edu.fapi.model;

import java.sql.Date;

public class Jogador {
    private String nome;
    private String situacao;
    private int numVidas;
    private Date inicioJogo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getNumVidas() {
        return numVidas;
    }

    public void setNumVidas(int numVidas) {
        this.numVidas = numVidas;
    }

    public Date getInicioJogo() {
        return inicioJogo;
    }

    public void setInicioJogo(Date inicioJogo) {
        this.inicioJogo = inicioJogo;
    }
}
