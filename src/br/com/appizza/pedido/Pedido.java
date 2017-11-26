/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appizza.pedido;

import br.com.appizza.formas.Forma;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Pedido {
    private int numeroPedido;
    private double valorTotal;
    private List<Forma> itens;
    private String status;

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Forma> getPedidos() {
        return itens;
    }

    public void setPedidos(List<Forma> pedidos) {
        this.itens = pedidos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public double calculaPrecoTotal(){
        for(int i = 0; i < itens.size(); i++){
            if(itens.get(i).getValor() != 0)
                valorTotal += itens.get(i).getValor();
            else
                return 0;//Retornar zero significa que alguma pizza não ta com valor calculado
        }
        return valorTotal;
    }

}
