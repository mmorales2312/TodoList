/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MMoralesTodoList.TodoList.ML;

import java.util.Date;

/**
 *
 * @author Alien 14
 */
public class Tarea {
    private int IdTarea;
    private String Titulo;
    private String Descripcion;
    private Date FechaVencimiento;
    public Estado estado;

    public Tarea(int idTarea, String Titulo, String Descripcion, Date FechaVencimiento, Estado estado) {
        this.IdTarea = idTarea;
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.FechaVencimiento = FechaVencimiento;
        this.estado = estado;
    }
    
    public Tarea(){
        
    }

    public int getIdTarea() {
        return IdTarea;
    }

    public void setIdTarea(int idTarea) {
        this.IdTarea = idTarea;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    
}
