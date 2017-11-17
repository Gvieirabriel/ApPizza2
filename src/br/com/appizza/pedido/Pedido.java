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
    private List<Forma> pedidos;
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
        return pedidos;
    }

    public void setPedidos(List<Forma> pedidos) {
        this.pedidos = pedidos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
