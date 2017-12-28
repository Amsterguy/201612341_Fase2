/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warlock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oscar
 */
public class Consultas extends Conexion{
    
    
    
    public boolean login(String usuario, String password) throws SQLException{
        
        PreparedStatement pst = null;
        ResultSet rs = null;        
        Connection dbConnection = null;

        
        try {   
            String selectSQL = "select * from usuario where nickname = ? and contrasenia = ?";
            pst = getConnection().prepareStatement(selectSQL);
            pst.setString(1, usuario);
            pst.setString(2, password);
            rs = pst.executeQuery();
            
            if( rs.absolute(1)){            
            return true;
            }
    } 
        catch (Exception e) {
            System.err.println("Error"+e);
        } finally{
            
            try{
                if(getConnection() != null) getConnection().close();
                if(pst != null) pst.close();
                if(rs != null)rs.close();
                
                
            }catch (Exception e) {
                System.err.println("Error"+e);
                {
                    {
                        return false;
                    }
                }
             
            }
            
        }
            return false;
    }
    
    public boolean register(String nombre, String correo, String fecha, String contrasenia, String nickname){
     
        
        
        PreparedStatement pst = null;
        ResultSet rs = null;        
        Connection dbConnection = null;

        
        try {   
            String selectSQL = "insert into USUARIO (nombre, correo, fecha, contrasenia, nickname, karma) values(?,?,?,?,?,0)";
            pst = getConnection().prepareStatement(selectSQL);
             
            pst.setString(1, nombre);
              pst.setString(2, correo);
               pst.setString(3, fecha);
                pst.setString(4, contrasenia);
                 pst.setString(5, nickname);
                 
            rs = pst.executeQuery();
    } 
        catch (Exception e) {
            System.err.println("Error"+e);
        } finally{
            
            try{
                if(getConnection() != null) getConnection().close();
                if(pst != null) pst.close();
                if(rs != null)rs.close();
                
                
            }catch (Exception e) {
                System.err.println("Error"+e);
                {
                    {
                        return false;
                    }
                }
             
            }
            return true;
        }
            
    }
}
