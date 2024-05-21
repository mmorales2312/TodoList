/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MMoralesTodoList.TodoList.DAO;

import com.MMoralesTodoList.TodoList.ML.Estado;
import com.MMoralesTodoList.TodoList.ML.Result;
import com.MMoralesTodoList.TodoList.ML.Tarea;
import com.MMoralesTodoList.TodoList.ML.Usuario;
import com.MMoralesTodoList.TodoList.ML.UsuarioTareas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alien 14
 */
@Repository
public class UsuarioDAOimplementation implements UsuarioDAO {
    
    private EntityManager entityManager;
    
    @Autowired //inyección 
    public void UsuarioDAOimplementation( EntityManager entityManager){ 
        this.entityManager = entityManager;
    }

    @Override
    public Result GetAllJPA(Usuario usuario) {
        Result result = new Result();
        //List<com.Digis1.MMoralesProgramacionNCapas1.JPA.Usuario> usuarios = entityManager.createQuery("FROM Usuario", com.Digis1.MMoralesProgramacionNCapas1.JPA.Usuario.class).getResultList();
        TypedQuery<com.MMoralesTodoList.TodoList.JPA.Usuario> query = entityManager.createQuery("FROM Usuario WHERE UserName =:username and Password =:password",  com.MMoralesTodoList.TodoList.JPA.Usuario.class);
        query.setParameter("username",  usuario.getUserName());
        query.setParameter("password", usuario.getPassword());
        List<com.MMoralesTodoList.TodoList.JPA.Usuario> usuarios = query.getResultList();
        
        List<UsuarioTareas> tareaDirecion = new ArrayList<>();
        for (com.MMoralesTodoList.TodoList.JPA.Usuario tarea : usuarios) {
            UsuarioTareas usuariosTarea = new UsuarioTareas();
            usuariosTarea.usuario = new Usuario();
            usuariosTarea.usuario.setUserName(tarea.getUserName());
            usuariosTarea.usuario.setFechaNacimiento(tarea.getFechaNacimiento());
            usuariosTarea.tarea = new Tarea();
            usuariosTarea.tarea.setIdTarea(tarea.tarea.getIdTarea());
            usuariosTarea.tarea.setTitulo(tarea.tarea.getTitulo());
            usuariosTarea.tarea.setDescripcion(tarea.tarea.getDescripcion());
            usuariosTarea.tarea.setFechaVencimiento(tarea.tarea.getFechaVencimiento());
            usuariosTarea.tarea.estado = new Estado();
            usuariosTarea.tarea.estado.setIdEstado(tarea.tarea.estado.getIdEstado());
            usuariosTarea.tarea.estado.setEstatus(tarea.tarea.estado.getEstatus());

            
            tareaDirecion.add(usuariosTarea);
       
        }
        result.Correct = true;
        result.object = usuarios;

        return result;
    }

    @Override
    @Transactional
    public Result AddJPA(UsuarioTareas usuarioTareas) {
        Result result = new Result();
        com.MMoralesTodoList.TodoList.JPA.Usuario usuariosJPA = new com.MMoralesTodoList.TodoList.JPA.Usuario();
        try{
        usuariosJPA.setIdUsuario(usuarioTareas.usuario.getIdUsuario());
        usuariosJPA.setNombreUsuario(usuarioTareas.usuario.getNombreUsuario());
        usuariosJPA.setApellidoMaterno(usuarioTareas.usuario.getApellidoMaterno());
        usuariosJPA.setApellidoPaterno(usuarioTareas.usuario.getApellidoPaterno());
        usuariosJPA.setFechaNacimiento(usuarioTareas.usuario.getFechaNacimiento());
        usuariosJPA.setUserName(usuarioTareas.usuario.getUserName());
        usuariosJPA.setPassword(usuarioTareas.usuario.getPassword());
        usuariosJPA.setEmail(usuarioTareas.usuario.getEmail());
        usuariosJPA.setImagen(usuarioTareas.usuario.getImagen());
        usuariosJPA.tarea = new com.MMoralesTodoList.TodoList.JPA.Tarea();
        usuariosJPA.tarea.setIdTarea(usuarioTareas.tarea.getIdTarea());
        usuariosJPA.tarea.setTitulo(usuarioTareas.tarea.getTitulo());
        
        entityManager.persist(usuariosJPA);
        result.Correct = true;
        
       }catch(Exception ex){
           result.Correct = false;
          result.ErrorMessage = ex.getLocalizedMessage();
          result.Ex = ex;
       }
        return result;
    }

    @Override
    public Result UpdateJPA(Usuario empresa) {
        Result result = new Result();
        return result;
    }

    @Override
    public Result DeleteJPA(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result GetByJPA(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result GetByUser(String UserName, String Password) {
       Result result = new Result();
        TypedQuery<com.MMoralesTodoList.TodoList.JPA.Usuario> query = entityManager.createQuery("FROM Usuario WHERE UserName =:username AND Password =:password", com.MMoralesTodoList.TodoList.JPA.Usuario.class);
        query.setParameter("username", UserName);
        query.setParameter("password", Password);
        com.MMoralesTodoList.TodoList.JPA.Usuario userName = query.getSingleResult();
        List<UsuarioTareas> tareaDirecion = new ArrayList<>();
        UsuarioTareas usuariosTarea = new UsuarioTareas();
        usuariosTarea.usuario = new Usuario();
        usuariosTarea.usuario.setUserName(userName.getUserName());
        usuariosTarea.usuario.setFechaNacimiento(userName.getFechaNacimiento());
        
        TypedQuery<com.MMoralesTodoList.TodoList.JPA.Tarea> query2 = entityManager.createQuery("FROM Tarea",  com.MMoralesTodoList.TodoList.JPA.Tarea.class);
        List<com.MMoralesTodoList.TodoList.JPA.Tarea> usuarios = query2.getResultList();
        
        
        for (com.MMoralesTodoList.TodoList.JPA.Tarea tarea : usuarios) {
            usuariosTarea.tarea = new Tarea();
            usuariosTarea.tarea.setIdTarea(tarea.getIdTarea());
            usuariosTarea.tarea.setTitulo(tarea.getTitulo());
            usuariosTarea.tarea.setDescripcion(tarea.getDescripcion());
            usuariosTarea.tarea.setFechaVencimiento(tarea.getFechaVencimiento());
            usuariosTarea.tarea.estado = new Estado();
            usuariosTarea.tarea.estado.setIdEstado(tarea.estado.getIdEstado());
            usuariosTarea.tarea.estado.setEstatus(tarea.estado.getEstatus());
            

            
            tareaDirecion.add(usuariosTarea);
       
        }
            
        result.Correct = true;
        result.object = usuarios;
        return result;
    }
    
}
