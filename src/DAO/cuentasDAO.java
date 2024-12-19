package DAO;

import model.cuentas;

public interface cuentasDAO {
    cuentas encontrarCuenta(int idCliente, int idCuenta);
    void actualizarmonto(cuentas Cuenta, double monto);

}
