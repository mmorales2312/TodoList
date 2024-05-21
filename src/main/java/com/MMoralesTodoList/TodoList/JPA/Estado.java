/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MMoralesTodoList.TodoList.JPA;

import com.MMoralesTodoList.TodoList.ML.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author Alien 14
 */
@Entity
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestado")
    private int IdEstado;
    
    @Column(name = "estatus")
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
