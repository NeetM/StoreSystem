package com.mycompany.proyecto_seba;

public class Compra {
    String cliente;
    double montoTotal;
    String metodoPago;

    public Compra(String cliente, double montoTotal, String metodoPago) {
        this.cliente = cliente;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}