/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appizza.cliente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Cliente {
    
    private int idCliente;
    private String nome;
    private String sobrenome;
    private int telefone;

    public Cliente() {
    }

    public Cliente(String nomeC, String sobrenomeC, int telefoneC) {
        this.nome = nomeC;
        this.sobrenome = sobrenomeC;
        this.telefone = telefoneC;
    }
   
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }    
}
