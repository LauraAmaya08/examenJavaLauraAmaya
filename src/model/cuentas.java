package model;

import java.sql.Timestamp;

public class cuentas {
    private int id, id_cliente;
    private String estado, tipo;
    private double saldo, limite_saldo;
    private Timestamp fecha_apertura;

    public int getId() {
        return id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getEstado() {
        return estado;
    }

    public String getTipo() {
        return tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite_saldo() {
        return limite_saldo;
    }

    public Timestamp getFecha_apertura() {
        return fecha_apertura;
    }

    public cuentas(int id, int id_cliente, String estado, String tipo, double saldo, double limite_saldo, Timestamp fecha_apertura) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.estado = estado;
        this.tipo = tipo;
        this.saldo = saldo;
        this.limite_saldo = limite_saldo;
        this.fecha_apertura = fecha_apertura;
    }
}
