/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appizza.sabor;

/**
 *
 * @author Leticia
 */
public class Sabor {
    private int idSabor;
    private String nome;  
    private int codTipo;
    
    public Sabor() {
    }

    public Sabor(String nomeS,int codT) {
        this.nome = nomeS;
        this.codTipo = codT;
    }

    public int getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(int idSabor) {
        this.idSabor = idSabor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(int codTipo) {
        this.codTipo = codTipo;
    }
    
    
}
