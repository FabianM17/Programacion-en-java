/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaeducativo;
import sistemaeducativo.controller.EstudianteController;
import sistemaeducativo.dao.EstudianteDAO;
import sistemaeducativo.view.EstudianteView;
/**
 *
 * @author UIS
 */
public class SistemaEducativo {

    public static void main(String[] args) {
        EstudianteView vista=new EstudianteView();
        EstudianteDAO dao=new EstudianteDAO();
        EstudianteController controlador=new EstudianteController(dao, vista);
        controlador.iniciar();
    }
    
}
