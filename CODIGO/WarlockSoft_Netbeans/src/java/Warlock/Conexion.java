/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warlock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author oscar
 */
public class Conexion {
 
    private String USERNAME = "root";
    private String PASSWORD = "";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "ipc2_proyecto_diciembre";
    private String CLASSNAME = "org.mariadb.jdbc.Driver";
    private String URL = "jdbc:mariadb://"+HOST+":"+PORT+"/"+DATABASE;
    private Connection con;
    
    public Conexion(){
    
        try{
            
            Class.forName(CLASSNAME);
            con =  DriverManager.getConnection(URL, USERNAME, PASSWORD);
        
        } catch (ClassNotFoundException e){
        
            System.err.println("ERROR "+e);
            
        } catch(SQLException e){
        
            System.err.println("Error "+e);
            
        }
    }
    
    public Connection getConnection(){    
        return con;
    }
    
    public static void main(String[] args){
    
        Conexion con = new Conexion();
    }
    
}
