/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MMoralesTodoList.TodoList.ML;

/**
 *
 * @author Alien 14
 */
public class UsuarioTareas {
    public Usuario usuario;
    public Tarea tarea;

    
    public UsuarioTareas(){
        
    }
    
    public UsuarioTareas(Usuario usuario, Tarea tarea) {
        this.usuario = usuario;
        this.tarea = tarea;
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
    
    
}
