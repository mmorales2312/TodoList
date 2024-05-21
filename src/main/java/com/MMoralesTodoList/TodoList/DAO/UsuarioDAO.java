/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MMoralesTodoList.TodoList.DAO;

import com.MMoralesTodoList.TodoList.ML.Result;
import com.MMoralesTodoList.TodoList.ML.Usuario;
import com.MMoralesTodoList.TodoList.ML.UsuarioTareas;

/**
 *
 * @author Alien 14
 */
public interface UsuarioDAO {
     Result GetAllJPA(Usuario usuario);
    Result AddJPA(UsuarioTareas usuarioTareas);
    Result UpdateJPA(Usuario empresa);
    Result DeleteJPA(int idUsuario);
    Result GetByJPA(int idUsuario);
    Result GetByUser(String UserName, String Password);
    
}
