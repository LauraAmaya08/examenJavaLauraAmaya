package Impl;

import DAO.ClienteDAO;
import model.clientes;
import connection.*;

import javax.swing.*;
import java.sql.*;

public class clienteImpl implements ClienteDAO {

    @Override
    public clientes validarCliente(String doc) {
        String sql = """
                SELECT * FROM clientes WHERE clientes.identificacion = ?;
                """;
        try (Connection conexion = connection.getConnection()) {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, doc);
            ResultSet resultSet = ps.executeQuery();
            String documentacion = null;
            int id = 0;
            String nombre = null;
            String apellido = null;
            String direccion = null;
            String telefono = null;
            String correo = null;
            String estado = null;
            Timestamp fecha_registro = null;
            Timestamp ultima_actividad = null;
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                documentacion = resultSet.getString("identificacion");
                nombre = resultSet.getString("nombre");
                apellido = resultSet.getString("apellido");
                direccion = resultSet.getString("direccion");
                telefono = resultSet.getString("telefono");
                correo = resultSet.getString("correo");
                estado = resultSet.getString("estado");
                fecha_registro = resultSet.getTimestamp("fecha_registro");
                ultima_actividad = resultSet.getTimestamp("ultima_actividad");

            }
            return new clientes(id, documentacion, nombre, apellido, direccion, telefono, correo, estado, fecha_registro, ultima_actividad);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            throw new RuntimeException(e.getMessage());
        }
    }
}
