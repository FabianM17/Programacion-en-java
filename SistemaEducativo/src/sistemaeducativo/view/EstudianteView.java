/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaeducativo.view;

import java.util.ArrayList;
import java.util.Scanner;
import sistemaeducativo.model.Estudiante;

/**
 *
 * @author UIS
 */
public class EstudianteView {

    static Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        try {
            System.out.println("MENÚ DE ESTUDIANTES\n1. Crear\n2. Listar\n3. Buscar por código\n4. Actualizar\n5. Eliminar\n6. Salir");
            int indice = sc.nextInt();
            if (indice <= 6 && indice >= 1) {
                return indice;
            } else {
                System.out.println("Fuera de rango.");
            }
        } catch (Exception f) {
            System.out.println("Error!");
        }
        return 0;
    }

    public String pedirTexto(String texto) {
        System.out.println(texto);
        String dato = sc.nextLine();
        return dato;
    }

    public double pedirDouble(String texto) {
        System.out.println(texto);
        try {
            double dato = sc.nextDouble();
            return dato;
        } catch (Exception f) {
            System.out.println("Error.");
        }
        return 0;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarTodo(ArrayList<Estudiante> estudiantes) {
        for (Estudiante e : estudiantes) {
            System.out.println(e.toString());
        }
    }

}
