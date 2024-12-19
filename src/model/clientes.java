package model;

import java.sql.Timestamp;

public class clientes {
    private int id;
    private String identificacion,nombre,apellido,direccion,telefono,correo,estado;
    private Timestamp fecha_registro, ultima_actividad;

    public clientes(int id, String identificacion, String nombre, String apellido, String direccion, String telefono, String correo, String estado, Timestamp fecha_registro, Timestamp ultima_actividad) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
        this.ultima_actividad = ultima_actividad;
    }

    public int getId() {
        return id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getEstado() {
        return estado;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public Timestamp getUltima_actividad() {
        return ultima_actividad;
    }

    @Override
    public String toString() {
        return
                "id= " + id + '\n' +
                "Identificacion= " + identificacion + '\n' +
                "Nombre= " + nombre + '\n' +
                "Apellido= " + apellido + '\n' +
                "Direccion= " + direccion + '\n' +
                "Telefono= " + telefono + '\n' +
                "Correo= " + correo + '\n' +
                "Estado= " + estado + '\n' +
                "Fecha registro=" + fecha_registro +  '\n' +
                "Ultima actividad=" + ultima_actividad + '\n';
    }
}
