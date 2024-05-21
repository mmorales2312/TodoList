/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MMoralesTodoList.TodoList.JPA;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Alien 14
 */
@Entity
@Table(name = "USUARIO")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int IdUsuario ;
    
    @Column(name = "nombreusuario")
    private String NombreUsuario;
    
    @Column(name = "apellidomaterno")
    private String ApellidoMaterno;
    
    @Column(name = "apellidopaterno")
    private String ApellidoPaterno;
    
    @Column(name = "fechanacimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    
    @Column(name = "username")
    private String UserName;
    
    @Column(name = "password")
    private String Password;
    
    @Column(name = "email")
    private String Email;
    
    @Column(name = "imagen")
    private String Imagen;
    
    @ManyToOne
    @JoinColumn(name = "idtarea")
    public Tarea tarea;
    
     public Usuario(String UserName, String Password){
        this.UserName = UserName;
        this.Password = Password; 
    }
    public Usuario(){
        
    }

    public Usuario(int idUsuario, String NombreUsuario, String ApellidoMaterno, String ApellidoPaterno, Date fechaNacimiento, String UserName, String Password, String Email, String Imagen, Tarea tarea) {
        this.IdUsuario = idUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ApellidoMaterno = ApellidoMaterno;
        this.ApellidoPaterno = ApellidoPaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.UserName = UserName;
        this.Password = Password;
        this.Email = Email;
        this.Imagen = Imagen;
        this.tarea = tarea;
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

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
    
    
    
    
}
