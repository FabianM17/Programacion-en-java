/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaeducativo.controller;
import java.util.ArrayList;
import sistemaeducativo.view.EstudianteView;
import sistemaeducativo.dao.IEstudianteDAO;
import sistemaeducativo.model.Estudiante;
/**
 *
 * @author UIS
 */
public class EstudianteController {
    private IEstudianteDAO dao; 
    private EstudianteView vista;

    public EstudianteController(IEstudianteDAO dao, EstudianteView vista) {
        this.dao = dao;
        this.vista = vista;
    }

    public void iniciar() {
        int opt;
        do {
            opt = vista.mostrarMenu();
            switch (opt) {
                case 1: registrar(); break;
                case 2: listar(); break;
                case 3: buscar(); break;
                case 4: actualizar(); break;
                case 5: eliminar(); break;
                case 6: vista.mostrarMensaje("¡Hasta luego!"); break;
                default: vista.mostrarMensaje("Opción inválida.");
            }
        } while (opt != 6);
    }

    private void registrar() {
        String codigo = vista.pedirTexto("Código: ");
        if (dao.buscarPorCodigo(codigo) != null) {
            vista.mostrarMensaje("Error: El código ya existe.");
            return;
        }
        String nombre = vista.pedirTexto("Nombre completo: ");
        String carrera = vista.pedirTexto("Carrera: ");
        double promedio = vista.pedirDouble("Promedio (0.0 a 5.0): ");

        Estudiante e = new Estudiante(0, codigo, nombre, carrera, promedio);
        if (dao.registrar(e)) {
            vista.mostrarMensaje("Estudiante registrado exitosamente.");
        } else {
            vista.mostrarMensaje("Error al registrar estudiante.");
        }
    }


    private void buscar() {
        String codigo = vista.pedirTexto("Ingrese código a buscar: ");
        Estudiante e = dao.buscarPorCodigo(codigo);
        if (e != null) {
            vista.mostrarMensaje("Encontrado: " + e.getNombre() + " | Carrera: " + e.getCarrera() + " | Promedio: " + e.getPromedio());
        } else {
            vista.mostrarMensaje("Estudiante no encontrado.");
        }
    }
    
    private void listar(){
        vista.mostrarTodo(dao.listar());
    }

    private void actualizar() {
        String codigo = vista.pedirTexto("Código del estudiante a actualizar: ");
        Estudiante e = dao.buscarPorCodigo(codigo);
        if (e == null) {
            vista.mostrarMensaje("Estudiante no existe.");
            return;
        }
        
        String nuevoNombre = vista.pedirTexto("Nuevo nombre: ");
        String nuevaCarrera = vista.pedirTexto("Nueva carrera: ");
        double nuevoPromedio = vista.pedirDouble("Nuevo promedio: ");

        e.setNombre(nuevoNombre);
        e.setCarrera(nuevaCarrera);
        e.setPromedio(nuevoPromedio);

        if (dao.actualizar(e)) {
            vista.mostrarMensaje("Estudiante actualizado correctamente.");
        } else {
            vista.mostrarMensaje("Error al actualizar.");
        }
    }

    private void eliminar() {
        String codigo = vista.pedirTexto("Código del estudiante a eliminar: ");
        if (dao.eliminar(codigo)) {
            vista.mostrarMensaje("Estudiante eliminado correctamente.");
        } else {
            vista.mostrarMensaje("No se pudo eliminar o el código no existe.");
        }
    }
}
    
    

