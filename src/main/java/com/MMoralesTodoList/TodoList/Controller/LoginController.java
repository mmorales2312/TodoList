/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MMoralesTodoList.TodoList.Controller;


import com.MMoralesTodoList.TodoList.DAO.TareaDAOimplementation;
import com.MMoralesTodoList.TodoList.DAO.UsuarioDAOimplementation;
import com.MMoralesTodoList.TodoList.ML.Result;
import com.MMoralesTodoList.TodoList.ML.Tarea;
import com.MMoralesTodoList.TodoList.ML.Usuario;
import com.MMoralesTodoList.TodoList.ML.UsuarioTareas;
import jakarta.validation.Valid;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Alien 14
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    
     @Autowired
    private UsuarioDAOimplementation usuarioDAOimplementation;
     
     @Autowired
     private TareaDAOimplementation tareaDAOimplementation;
     
     @GetMapping
     public String Login(Model model){ 
        model.addAttribute("usuario", new Usuario());
        return "LoginUsuario";
     }
     
     @PostMapping("/form")
     public String UserName(@RequestParam("UserName") String UserName, String Password,Model model){
         Result result;
         Result result1;
       result = usuarioDAOimplementation.GetByUser(UserName, Password);      
       if(result.Correct){
           model.addAttribute("usuarioTaras", (List<UsuarioTareas>) result.object);
           
           return "TareasGetAll";
       }else{
           return "LoginUsuario";
       }
       
         
     }
     @GetMapping("/form/{idUsuario}")
    public String Form(@PathVariable int idUsuario, Model model){
            
        Result result = tareaDAOimplementation.GetAllJPA();
        model.addAttribute("tareas", (List<Tarea>) result.object);

           if (idUsuario == 0) {
            UsuarioTareas usuariosTarea = new UsuarioTareas();
            usuariosTarea.usuario = new Usuario();
            usuariosTarea.usuario.tarea = new Tarea();
            model.addAttribute("usuarios", usuariosTarea);  //modelo vacio cuando hacemos un ADD
        } else {
            return "FormUsuario";
        }  
            return "FormUsuario";
    }
     
      @PostMapping("/guardar")  //Recuperar los datos de formulario
    public String form(@Valid @ModelAttribute UsuarioTareas usuarioTareas,
             BindingResult bindingeResult,
            @RequestParam("imagenFile") MultipartFile imagenFile,
             Model model){
        
        Result result;
        
        if (bindingeResult.hasErrors()) {
            model.addAttribute("usuarios", usuarioTareas);
            return "FormUsuario";
        } else {
            
        try {
            if(!imagenFile.isEmpty()) {
                byte[] bytes = imagenFile.getBytes();
                String imageBase64 = Base64.encodeBase64String(bytes);
                usuarioTareas.usuario.setImagen(imageBase64);
            }
        } catch (Exception ex) {
            System.out.println("no tenemos imagen");    
        } 
        
        if (usuarioTareas.usuario.getIdUsuario() == 0) { 
         result = usuarioDAOimplementation.AddJPA(usuarioTareas);
        } else { 
                return "TareasGetAll";
        }
        
        return "FormUsuario";
    }
            
        }

   
}
