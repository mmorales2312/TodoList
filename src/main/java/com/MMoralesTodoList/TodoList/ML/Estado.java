/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MMoralesTodoList.TodoList.ML;

/**
 *
 * @author Alien 14
 */
public class Estado {
    private int IdEstado;
    private String Estatus;

    public int getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(int idEstado) {
        this.IdEstado = idEstado;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }

    public Estado(int idEstado, String Estatus) {
        this.IdEstado = idEstado;
        this.Estatus = Estatus;
    }
    
    public Estado(){
        
    }
    
}
