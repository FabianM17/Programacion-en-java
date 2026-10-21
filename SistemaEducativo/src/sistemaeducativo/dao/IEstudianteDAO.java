/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaeducativo.dao;
import sistemaeducativo.model.Estudiante;
import java.util.ArrayList;
/**
 *
 * @author UIS
 */
public interface IEstudianteDAO {
    boolean registrar(Estudiante e);
    boolean actualizar(Estudiante e);
    boolean eliminar(String codigo);
    Estudiante buscarPorCodigo(String codigo);
    ArrayList<Estudiante> listar();
}
