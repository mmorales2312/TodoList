/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MMoralesTodoList.TodoList.DAO;

import com.MMoralesTodoList.TodoList.ML.Estado;
import com.MMoralesTodoList.TodoList.ML.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alien 14
 */
@Repository
public class EstadoDAOimplementation implements EstadoDAO {
    
    EntityManager entityManager;
    
    @Autowired
    public void UsuarioDAOimplementation( EntityManager entityManager){ 
        this.entityManager = entityManager;
    }

    @Override
    public Result GetAll() {
        Result result = new Result();
        TypedQuery<com.MMoralesTodoList.TodoList.JPA.Estado> query =  entityManager.createQuery("FROM Estado", com.MMoralesTodoList.TodoList.JPA.Estado.class);
        List<com.MMoralesTodoList.TodoList.JPA.Estado> estados = query.getResultList();
        List<Estado> Estado = new ArrayList<>();
        for (com.MMoralesTodoList.TodoList.JPA.Estado estado : estados) {
            Estado estadoAll = new Estado();
            estadoAll.setIdEstado(estado.getIdEstado());
            estadoAll.setEstatus(estado.getEstatus());
            
            Estado.add(estadoAll);
       
        }
        result.Correct = true;
        result.object = estados;

        return result;
        
    }
    
}
