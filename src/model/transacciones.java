package model;

import java.sql.Timestamp;

public class transacciones {
    private int id_cuenta;
    private String estado, tipo, referencia;
    private float saldo_anterior, saldo_nuevo, monto;
    private Timestamp fecha_apertura;

    public transacciones( int id_cuenta, String estado, String tipo, String referencia, float saldo_anterior, float saldo_nuevo, float monto, Timestamp fecha_apertura) {
        this.id_cuenta = id_cuenta;
        this.estado = estado;
        this.tipo = tipo;
        this.referencia = referencia;
        this.saldo_anterior = saldo_anterior;
        this.saldo_nuevo = saldo_nuevo;
        this.monto = monto;
        this.fecha_apertura = fecha_apertura;
    }
}
