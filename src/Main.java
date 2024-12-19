import Impl.chequesImpl;
import Impl.clienteImpl;
import Impl.cuentasImpl;
import model.clientes;
import model.cuentas;

import javax.swing.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        clienteImpl cliente = new clienteImpl();
        cuentasImpl cuenta = new cuentasImpl();
        chequesImpl cheque = new chequesImpl();

        System.out.println("Bienvenido al banco Unión, seleccione una opción:\n1. Generar cheque \n2. Listar cheques de cliente\n3. Ver reportes generales \n4. Ver reporte de Inactividad\n5. Ver reporte de Cheques Pendientes y Recientes\n6. Salir");
        String opcion = consola.nextLine();
        while (Integer.valueOf(opcion) != 6){
            switch (opcion){
                case "1":
                    System.out.println("Ingrese el documento del cliente: ");
                    String documentoCliente = consola.nextLine();
                    clientes Cliente = cliente.validarCliente(documentoCliente);
                    System.out.println(Cliente);
                    if (Cliente.getId() != 0){
                        if (!(Cliente.getEstado().equals("Inactivo"))){
                            System.out.println("Ingrese el ID de la cuenta: ");
                            int id_c = consola.nextInt();
                            cuentas Cuenta = cuenta.encontrarCuenta(Cliente.getId(), id_c);
                            if (Cuenta.getId() != 0 && (Cuenta.getTipo().equals("Personal") && Cuenta.getSaldo() > 10000000)){
                                System.out.println("Ingresa el monto del cheque: ");
                                double monto = consola.nextDouble();
                                if (Cuenta.getSaldo() > (Cuenta.getSaldo()- monto)){
                                    System.out.println("Ingresa el destinatario: ");
                                    String destinatario = consola.nextLine();

                                    System.out.println("Ingresa firma digital: ");
                                    String firma = consola.nextLine();
                                    System.out.println("Ingresa la prioridad del cheque: ");
                                    String prioridad = consola.nextLine();
                                    cheque.generarNuevoCheque(Cliente,monto,Cuenta,firma,prioridad,destinatario);
                                    cuenta.actualizarmonto(Cuenta,monto);
                                } else {
                                    JOptionPane.showMessageDialog(null,"Saldo Insuficiente");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,"Problemas con la cuenta");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,"Usuario inactivo");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Usuario no encontrado");
                    }
                    break;
                case "2":
                    System.out.println("Ingrese el documento del cliente: ");
                    String documentoCliente2 = consola.nextLine();
                    clientes Cliente2 = cliente.validarCliente(documentoCliente2);
                    cheque.listarCheques(Cliente2);
                    if (Cliente2.getId() != 0){

                    } else {
                        JOptionPane.showMessageDialog(null,"Usuario no encontrado");
                        break;
                    }
                    break;
            }
        }
        System.out.println("Hasta pronto!");
    }
}