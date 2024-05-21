/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MMoralesTodoList.TodoList.Controller;

import com.MMoralesTodoList.TodoList.DAO.EstadoDAOimplementation;
import com.MMoralesTodoList.TodoList.DAO.TareaDAOimplementation;
import com.MMoralesTodoList.TodoList.DAO.UsuarioDAOimplementation;
import com.MMoralesTodoList.TodoList.ML.Estado;
import com.MMoralesTodoList.TodoList.ML.Result;
import com.MMoralesTodoList.TodoList.ML.Tarea;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Alien 14
 */
@Controller
@RequestMapping("/tarea")
public class TareaController {
    
    @Autowired
    TareaDAOimplementation tareaDAOimplementation;
    
    @Autowired
    EstadoDAOimplementation estadoDAOimplementation;
    
    
        @GetMapping
        public String GetAll(Model model){
        Result result = tareaDAOimplementation.GetAllJPA();
        if (result.Correct) {
           model.addAttribute("usuarioTaras", (List<Tarea>) result.object);
            return "TareasGetAll";
        } else {
             return "";
        }
    }
        
        @GetMapping("/pendiente")
        public String GetAllPendiente(Model model){
        Result result = tareaDAOimplementation.GetAllPendiente();
        if (result.Correct) {
           model.addAttribute("usuarioTaras", (List<Tarea>) result.object);
            return "TareasGetAll";
        } else {
             return "";
        }
    }
        @GetMapping("/completado")
        public String GetAllCompletado(Model model){
        Result result = tareaDAOimplementation.GetAllCompletado();
        if (result.Correct) {
           model.addAttribute("usuarioTaras", (List<Tarea>) result.object);
            return "TareasGetAll";
        } else {
             return "";
        }
    }
        @GetMapping("/vencido")
        public String GetAllVencido(Model model){
        Result result = tareaDAOimplementation.GetAllExpirado();
        if (result.Correct) {
           model.addAttribute("usuarioTaras", (List<Tarea>) result.object);
            return "TareasGetAll";
        } else {
             return "TareasGetAll";
        }
    }
    
     @GetMapping("/form/{idTarea}")
    public String Form(@PathVariable int idTarea, Model model){
            Result result = estadoDAOimplementation.GetAll();
            model.addAttribute("estados", (List<Estado>) result.object);
           if (idTarea == 0) {          
            Tarea tarea  = new Tarea();
            tarea.estado= new Estado();
            model.addAttribute("tareas", tarea);  //modelo vacio cuando hacemos un ADD
        } else {
            //UsuarioDireccion usuarioRecuperado = usuarioDAOimplementation.GetByid(IdUsuario);
            //model.addAttribute("usuarioDireccion", usuarioRecuperado);
            Tarea tarea = (Tarea) tareaDAOimplementation.GetByJPA(idTarea).object;
            model.addAttribute("tareas", tarea); 
        }  
            return "TareasGetAll";
    }
    
    @PostMapping("/form")  //Recuperar los datos de formulario
    public String form(@ModelAttribute Tarea tarea, Model model){
        Result result;
        if (tarea.getIdTarea() == 0) { // INSERTAR DATOS
        // usuarioDAOimplementation.add(usuarioDireccion);
         result = tareaDAOimplementation.AddJPA(tarea);
        } else { 
                //usuarioDAOimplementation.UpdateSP(usuarioDireccion);
                result = tareaDAOimplementation.UpdateJPA(tarea);
        }
        
        return "TareasGetAll";    
    }
    
        @PostMapping("/eliminar/{idEmpresa}")  //Recuperar los datos de formulario
        public String Delete(@PathVariable int idEmpresa){
        if (idEmpresa > 0) { // INSERTAR DATOS
         tareaDAOimplementation.DeleteJPA(idEmpresa);
         
        } else { 
                return "";
        }
        return "EmpresaAll";
        }
    
}
