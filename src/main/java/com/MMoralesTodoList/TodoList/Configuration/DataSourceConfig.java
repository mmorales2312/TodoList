/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MMoralesTodoList.TodoList.Configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Alien 14
 */
@Configuration
public class DataSourceConfig {
     
    private SimpleJdbcCall simpleJdbcCall;
     
    @Bean // inicializa un objeto con valores por defecto / ejecuta método / 
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
        dataSource.setUsername("MMoralesTodoList");
        dataSource.setPassword("password1");
        
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
       return new JdbcTemplate(dataSource);
    }
    
}
