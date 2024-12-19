package DAO;

import model.clientes;
import model.cuentas;

public interface chequesDAO {
    void generarNuevoCheque(clientes Cliente, double monto, cuentas Cuenta, String firma, String prioridad,  String destinatario);

    void listarCheques(clientes Cliente);

}
