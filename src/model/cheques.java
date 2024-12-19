package model;

import java.sql.Date;
import java.sql.Timestamp;

public class cheques {
    private int id_cuenta;
    private String beneficiario, numero_cheque, monto_letras, prioridad, firma_digital,estado, razon_rechazo, usuario_modificacion;
    private double monto, cuenta_saldo_momento;
    private Timestamp fecha_proceso, fecha_modificacion;
    private Date fecha_emision;
    private boolean cobrado;

    public int getId_cuenta() {
        return id_cuenta;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public String getNumero_cheque() {
        return numero_cheque;
    }

    public String getMonto_letras() {
        return monto_letras;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getFirma_digital() {
        return firma_digital;
    }

    public String getEstado() {
        return estado;
    }

    public String getRazon_rechazo() {
        return razon_rechazo;
    }

    public String getUsuario_modificacion() {
        return usuario_modificacion;
    }

    public double getMonto() {
        return monto;
    }

    public double getCuenta_saldo_momento() {
        return cuenta_saldo_momento;
    }

    public Timestamp getFecha_proceso() {
        return fecha_proceso;
    }

    public Timestamp getFecha_modificacion() {
        return fecha_modificacion;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    public cheques(int id_cuenta, String beneficiario, String numero_cheque, String monto_letras, String prioridad, String firma_digital, String estado, String razon_rechazo, String usuario_modificacion, double monto, double cuenta_saldo_momento, Timestamp fecha_proceso, Timestamp fecha_modificacion, Date fecha_emision, boolean cobrado) {
        this.id_cuenta = id_cuenta;
        this.beneficiario = beneficiario;
        this.numero_cheque = numero_cheque;
        this.monto_letras = monto_letras;
        this.prioridad = prioridad;
        this.firma_digital = firma_digital;
        this.estado = estado;
        this.razon_rechazo = razon_rechazo;
        this.usuario_modificacion = usuario_modificacion;
        this.monto = monto;
        this.cuenta_saldo_momento = cuenta_saldo_momento;
        this.fecha_proceso = fecha_proceso;
        this.fecha_modificacion = fecha_modificacion;
        this.fecha_emision = fecha_emision;
        this.cobrado = cobrado;
    }
}
