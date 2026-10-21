/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaeducativo.model;

/**
 *
 * @author UIS
 */
public class Estudiante {
    
    private int id;
    private String codigo;
    private String nombre;
    private String carrera;
    private double promedio;

    public Estudiante(int id, String codigo, String nombre, String carrera, double promedio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    public Estudiante() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", carrera=" + carrera + ", promedio=" + promedio + '}';
    }
    
    
    
}
