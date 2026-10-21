/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaeducativo.dao;

import sistemaeducativo.dao.IEstudianteDAO;
import sistemaeducativo.model.Estudiante;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author UIS
 */
public class EstudianteDAO implements IEstudianteDAO {

    ArrayList<Estudiante> listaEstudiantes;

    public EstudianteDAO() {
        this.listaEstudiantes = new ArrayList<>();
    }

    @Override
    public boolean registrar(Estudiante e) {
        try {
            listaEstudiantes.add(e);
            return true;
        } catch (Exception f) {
            System.out.println("Error al registrar");
            return false;
        }
    }

    @Override
    public boolean actualizar(Estudiante e) {
        try {
            Estudiante f = buscarPorCodigo(e.getCodigo());
            listaEstudiantes.set(listaEstudiantes.indexOf(f), e);
            return true;
        } catch (Exception g) {
            return false;
        }
    }

    @Override
    public boolean eliminar(String codigo) {
        try {
            listaEstudiantes.remove(buscarPorCodigo(codigo));
        } catch (Exception f) {
            return false;
        }
        return false;
    }

    @Override
    public Estudiante buscarPorCodigo(String codigo) {
        try {
            for (Estudiante e : listaEstudiantes) {
                if (e.getCodigo() == codigo) {
                    return e;
                }
            }
        } catch (Exception f) {
            System.out.println("Error");
            return null;
        }
        return null;
    }

    @Override
    public ArrayList<Estudiante> listar() {
        return listaEstudiantes;
    }

}
