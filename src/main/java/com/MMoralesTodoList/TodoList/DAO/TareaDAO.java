/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MMoralesTodoList.TodoList.DAO;

import com.MMoralesTodoList.TodoList.ML.Estado;
import com.MMoralesTodoList.TodoList.ML.Result;
import com.MMoralesTodoList.TodoList.ML.Tarea;

/**
 *
 * @author Alien 14
 */
public interface TareaDAO {  
    Result GetAllJPA();
    Result GetAllPendiente();
    Result GetAllCompletado();
    Result GetAllExpirado();
    Result AddJPA(Tarea tarea);
    Result UpdateJPA(Tarea tarea);
    Result DeleteJPA(int idTarea);
    Result GetByJPA(int idTarea);
    
}
