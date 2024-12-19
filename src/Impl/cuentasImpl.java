package Impl;

import DAO.cuentasDAO;
import connection.connection;
import model.clientes;
import model.cuentas;

import javax.swing.*;
import java.sql.*;

public class cuentasImpl implements cuentasDAO {
    @Override
    public cuentas encontrarCuenta(int idCliente, int idCuenta) {
        String sql = """
            SELECT *
            FROM cuentas c WHERE c.id_cliente = ? AND c.id = ?;
        """;
        try (Connection conexion = connection.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.setInt(2, idCuenta);
            ResultSet resultSet = ps.executeQuery();
            int id = 0;
            int id_cliente = 0;
            String tipo = null;
            double saldo = 0;
            double limite_saldo = 0;
            String estadoC = null;
            Timestamp fecha_apertura = null;
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                id_cliente = resultSet.getInt("id_cliente");
                tipo = resultSet.getString("tipo");
                saldo = resultSet.getFloat("saldo");
                limite_saldo = resultSet.getFloat("limite_saldo");
                estadoC = resultSet.getString("estado");
                fecha_apertura = resultSet.getTimestamp("fecha_apertura");

            }
            return new cuentas(id, id_cliente, estadoC, tipo, saldo, limite_saldo, fecha_apertura );

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void actualizarmonto(cuentas Cuenta, double monto) {
        double nuevoMonto =  Cuenta.getSaldo() - monto;
        String sql = """
            UPDATE `cuentas` SET `saldo` = ? WHERE `id`= ?;
        """;
        try (Connection conexion = connection.getConnection()){
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDouble(1, nuevoMonto);
            ps.setInt(2, Cuenta.getId());
            ps.executeUpdate();
            System.out.println("Saldo Actualizado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}













































