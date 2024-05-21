/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MMoralesTodoList.TodoList.DAO;

import com.MMoralesTodoList.TodoList.ML.Estado;
import com.MMoralesTodoList.TodoList.ML.Result;
import com.MMoralesTodoList.TodoList.ML.Tarea;
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
public class TareaDAOimplementation implements TareaDAO {
    
     private EntityManager entityManager;
    
    @Autowired //inyección 
    public void UsuarioDAOimplementation( EntityManager entityManager){ 
        this.entityManager = entityManager;
    }
    
    
    @Override
    @Transactional
    public Result AddJPA(Tarea tarea) {
        Result result = new Result();
        com.MMoralesTodoList.TodoList.JPA.Tarea tareasJPA = new com.MMoralesTodoList.TodoList.JPA.Tarea();
        try{
        tareasJPA.setIdTarea(tarea.getIdTarea());
        tareasJPA.setTitulo(tarea.getTitulo());
        tareasJPA.setDescripcion(tarea.getDescripcion());
        tareasJPA.setFechaVencimiento(tarea.getFechaVencimiento());
        tareasJPA.estado = new com.MMoralesTodoList.TodoList.JPA.Estado();
        tareasJPA.estado.setIdEstado(tarea.estado.getIdEstado());
        tareasJPA.estado.setEstatus(tarea.estado.getEstatus());
        
        entityManager.persist(tareasJPA);
        result.Correct = true;
        
       }catch(Exception ex){
           result.Correct = false;
          result.ErrorMessage = ex.getLocalizedMessage();
          result.Ex = ex;
       }
        return result;
    }

    @Override
    @Transactional
    public Result UpdateJPA(Tarea tarea) {
         Result result = new Result();
         com.MMoralesTodoList.TodoList.JPA.Tarea tareasJPA = new com.MMoralesTodoList.TodoList.JPA.Tarea();
         com.MMoralesTodoList.TodoList.JPA.Estado estadosJPA = new com.MMoralesTodoList.TodoList.JPA.Estado();
         tareasJPA.setIdTarea(tarea.getIdTarea());
        tareasJPA.setTitulo(tarea.getTitulo());
        tareasJPA.setDescripcion(tarea.getDescripcion());
        tareasJPA.setFechaVencimiento(tarea.getFechaVencimiento());
        tareasJPA.estado.setIdEstado(tarea.getIdTarea());
        
        entityManager.merge(tareasJPA);
        return result;
    }

    @Override
    public Result DeleteJPA(int idTarea) {
         Result result = new Result();
       TypedQuery<com.MMoralesTodoList.TodoList.JPA.Tarea> query = entityManager.createQuery("FROM Tarea WHERE  IdTarea =:idTarea", com.MMoralesTodoList.TodoList.JPA.Tarea.class);
        query.setParameter("idTarea", idTarea);
        com.MMoralesTodoList.TodoList.JPA.Estado estadosJPA = new com.MMoralesTodoList.TodoList.JPA.Estado();
        
        entityManager.remove(query);
        return result;
    }

    @Override
    public Result GetByJPA(int idTarea) {
         Result result = new Result();
       try{
        TypedQuery<com.MMoralesTodoList.TodoList.JPA.Tarea> query = entityManager.createQuery("FROM Tarea WHERE  IdTarea =:idTarea", com.MMoralesTodoList.TodoList.JPA.Tarea.class);
        query.setParameter("idTarea", idTarea);
        com.MMoralesTodoList.TodoList.JPA.Tarea tareasJPA = query.getSingleResult();
        Tarea tarea = new Tarea();
        tarea.setIdTarea(tareasJPA.getIdTarea());
        tarea.setTitulo(tareasJPA.getTitulo());
        tarea.setDescripcion(tareasJPA.getDescripcion());
        tarea.setFechaVencimiento(tareasJPA.getFechaVencimiento());
        tarea.estado = new Estado();
        tarea.estado.setIdEstado(tareasJPA.estado.getIdEstado());
        tarea.estado.setEstatus(tareasJPA.estado.getEstatus());
       
        result.object = tarea;
        
       }catch(Exception ex){
           result.Correct = false;
          result.ErrorMessage = ex.getLocalizedMessage();
          result.Ex = ex;
       }

        return result;
    }

    @Override
    public Result GetAllJPA() {
       Result result = new Result();
        
        TypedQuery<com.MMoralesTodoList.TodoList.JPA.Tarea> query = entityManager.createQuery("FROM Tarea",  com.MMoralesTodoList.TodoList.JPA.Tarea.class);

        List<com.MMoralesTodoList.TodoList.JPA.Tarea> tareas = query.getResultList();
        List<Tarea> Tarea = new ArrayList<>();
        for (com.MMoralesTodoList.TodoList.JPA.Tarea tarea : tareas) {
            Tarea tareaAll = new Tarea();
            tareaAll.setIdTarea(tarea.getIdTarea());
            tareaAll.setTitulo(tarea.getTitulo());
            tareaAll.setDescripcion(tarea.getDescripcion());
            tareaAll.setFechaVencimiento(tarea.getFechaVencimiento());
            tareaAll.estado = new Estado();
            tareaAll.estado.setIdEstado(tarea.estado.getIdEstado());
            tareaAll.estado.setEstatus(tarea.estado.getEstatus());
            
            Tarea.add(tareaAll);
       
        }
        result.Correct = true;
        result.object = tareas;

        return result;
    }

    @Override
    public Result GetAllPendiente() {
        Result result = new Result();
        
        TypedQuery<com.MMoralesTodoList.TodoList.JPA.Tarea> query = entityManager.createQuery("FROM Tarea",  com.MMoralesTodoList.TodoList.JPA.Tarea.class);
        List<com.MMoralesTodoList.TodoList.JPA.Tarea> tareas = query.getResultList();
        List<Tarea> Tarea = new ArrayList<>();
         for (com.MMoralesTodoList.TodoList.JPA.Tarea tarea : tareas) {
           
            Tarea tareaAll = new Tarea();
            tareaAll.setIdTarea(tarea.getIdTarea());
            tareaAll.setTitulo(tarea.getTitulo());
            tareaAll.setDescripcion(tarea.getDescripcion());
            tareaAll.setFechaVencimiento(tarea.getFechaVencimiento());
            tareaAll.estado = new Estado();
            tareaAll.estado.setIdEstado(tarea.estado.getIdEstado());
            tareaAll.estado.setEstatus(tarea.estado.getEstatus());
                
               if (tarea.estado.getIdEstado() == 2) {   
            Tarea.add(tareaAll);

        }
             
             }
        if (!Tarea.isEmpty()) {
        result.Correct = true;
        result.object = Tarea;
        }

        return result;
    }

    @Override
    public Result GetAllCompletado() {
         Result result = new Result();
        
        TypedQuery<com.MMoralesTodoList.TodoList.JPA.Tarea> query = entityManager.createQuery("FROM Tarea",  com.MMoralesTodoList.TodoList.JPA.Tarea.class);
        List<com.MMoralesTodoList.TodoList.JPA.Tarea> tareas = query.getResultList();
        List<Tarea> Tarea = new ArrayList<>();
        for (com.MMoralesTodoList.TodoList.JPA.Tarea tarea : tareas) {
           
            Tarea tareaAll = new Tarea();
            tareaAll.setIdTarea(tarea.getIdTarea());
            tareaAll.setTitulo(tarea.getTitulo());
            tareaAll.setDescripcion(tarea.getDescripcion());
            tareaAll.setFechaVencimiento(tarea.getFechaVencimiento());
            tareaAll.estado = new Estado();
            tareaAll.estado.setIdEstado(tarea.estado.getIdEstado());
            tareaAll.estado.setEstatus(tarea.estado.getEstatus());
                
               if (tarea.estado.getIdEstado() == 1) {   
            Tarea.add(tareaAll);

        }
             
             }
        if (!Tarea.isEmpty()) {
        result.Correct = true;
        result.object = Tarea;
        }

        return result;
    }

    @Override
    public Result GetAllExpirado() {
        Result result = new Result();
        
        TypedQuery<com.MMoralesTodoList.TodoList.JPA.Tarea> query = entityManager.createQuery("FROM Tarea",  com.MMoralesTodoList.TodoList.JPA.Tarea.class);
        List<com.MMoralesTodoList.TodoList.JPA.Tarea> tareas = query.getResultList();
        List<Tarea> Tarea = new ArrayList<>();
        for (com.MMoralesTodoList.TodoList.JPA.Tarea tarea : tareas) {
            
            Tarea tareaAll = new Tarea();
            tareaAll.setIdTarea(tarea.getIdTarea());
            tareaAll.setTitulo(tarea.getTitulo());
            tareaAll.setDescripcion(tarea.getDescripcion());
            tareaAll.setFechaVencimiento(tarea.getFechaVencimiento());
            tareaAll.estado = new Estado();
            tareaAll.estado.setIdEstado(tarea.estado.getIdEstado());
            tareaAll.estado.setEstatus(tarea.estado.getEstatus());
             if (tarea.estado.getIdEstado() >= 3) {   
            Tarea.add(tareaAll);

        }
             
             }
        if (!Tarea.isEmpty()) {
        result.Correct = true;
        result.object = Tarea;
        }

        return result;
    }
    
    
}
