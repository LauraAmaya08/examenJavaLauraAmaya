package Impl;

import DAO.chequesDAO;
import connection.connection;
import model.cheques;
import model.clientes;
import model.cuentas;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class chequesImpl implements chequesDAO {

    @Override
    public void generarNuevoCheque(clientes Cliente, double monto, cuentas Cuenta, String firma, String prioridad, String destinatario) {
        int no_cheque = 1;
        String sql = """
                INSERT INTO `cheques`(numero_cheque,`id_cuenta`,`beneficiario`,`monto`,`monto_letras`,`prioridad`,`firma_digital`, `estado`, `razon_rechazo`,`fecha_emision`, `fecha_proceso`, `cobrado`, `cuenta_saldo_momento`, `fecha_modificacion`,`usuario_modificacion` ) VALUES
                (?,?,?,?,"Cero",?,?, "Pendiente", NULL, NOW(), NULL, 0, ?, NULL, NULL);
                """;
        try (Connection conexion = connection.getConnection()){
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, no_cheque);
            ps.setInt(2, Cuenta.getId());
            ps.setString(3, destinatario);
            ps.setDouble(4, monto);
            ps.setString(5, prioridad);
            ps.setString(6, firma);
            ps.setDouble(7, Cuenta.getSaldo());
            ps.executeUpdate();

            System.out.println("Cheque generado correctamente");


        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        ++no_cheque;
    }


    @Override
    public void listarCheques(clientes Cliente) {
        System.out.println("hola");
        ArrayList<cheques> cantidadCheques = new ArrayList<cheques>();
            String sql = """
                        SELECT *
                        FROM cheques c
                        JOIN cuentas cu ON cu.id = c.id_cuenta
                        JOIN clientes cl ON cl.id = cu.id_cliente AND cl.identificacion = ?;
        """;
            try (Connection conexion = connection.getConnection()) {
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setInt(1, Cliente.getId());
                ResultSet resultSet = ps.executeQuery();
                int id_cuenta = 0;
                String beneficiario = null;
                String numero_cheque = null;
                String monto_letras = null;
                String prioridad = null;
                String firma_digital = null;
                String estado = null;
                String razon_rechazo = null;
                String usuario_modificacion = null;
                double monto = 0;
                double cuenta_saldo_momento = 0;
                Timestamp fecha_proceso = null;
                Timestamp fecha_modificacion = null;
                Date fecha_emision = null;
                boolean cobrado = false;
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    numero_cheque = resultSet.getString("numero_cheque");
                    id_cuenta = resultSet.getInt("id_cuenta");
                    beneficiario = resultSet.getString("beneficiario");
                    monto = resultSet.getDouble("monto");
                    monto_letras = resultSet.getString("monto_letras");
                    prioridad = resultSet.getString("prioridad");
                    firma_digital = resultSet.getString("firma_digital");
                    estado = resultSet.getString("estado");
                    razon_rechazo = resultSet.getString("razon_rechazo");
                    fecha_emision = resultSet.getDate("fecha_emision");
                    cobrado = resultSet.getBoolean("cobrado");
                    cuenta_saldo_momento = resultSet.getDouble("cuenta_saldo_momento");
                    fecha_proceso = resultSet.getTimestamp("fecha_proceso");
                    fecha_modificacion = resultSet.getTimestamp("fecha_modificacion");
                    usuario_modificacion = resultSet.getString("usuario_modificacion");
                    cheques cheque = new cheques(id_cuenta, beneficiario, numero_cheque, monto_letras, prioridad, firma_digital, estado, razon_rechazo, usuario_modificacion, monto, cuenta_saldo_momento, fecha_proceso, fecha_modificacion, fecha_emision, cobrado);

                }

                for (cheques Cheque: cantidadCheques){
                    System.out.println(
                            "---------------------------------------\n" + "BANCO UNIÓN S.A.\n" + "Cheque No: "+ Cheque.getNumero_cheque()+ "\nFecha: " + Cheque.getFecha_emision()+ "\n\nPAGUESE A: "+Cheque.getBeneficiario()+ "\nLA SUMA DE: "+Cheque.getMonto_letras()+
                                    "\n\nValor: $"+ Cheque.getMonto()+ "\nFIRMA DIGITAL: "+Cheque.getFirma_digital()+"\n---------------------------------------"
                    );
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error");
                throw new RuntimeException(e.getMessage());
            }
        }

}

