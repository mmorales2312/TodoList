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
public class Usuario {
    private int IdUsuario ;
    private String NombreUsuario;
    private String ApellidoMaterno;
    private String ApellidoPaterno;
    private Date fechaNacimiento;
    private String UserName;
    private String Password;
    private String Email;
    private String Imagen;
    public Tarea tarea;
    
    public Usuario(){
        
    }
    public Usuario(String UserName, String Password){
        this.UserName = UserName;
        this.Password = Password; 
    }

    public Usuario(int idUsuario, String NombreUsuario, String ApellidoMaterno, String ApellidoPaterno, Date fechaNacimiento, String UserName, String Password, String Email, String Imagen) {
        this.IdUsuario = idUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ApellidoMaterno = ApellidoMaterno;
        this.ApellidoPaterno = ApellidoPaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.UserName = UserName;
        this.Password = Password;
        this.Email = Email;
        this.Imagen = Imagen;
    }
    
    
    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.IdUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    
}
