/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Warlock.Consultas;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author oscar
 */
@WebService(serviceName = "Warlock_Web")
public class Warlock {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "nickname") String nickname,@WebParam(name = "contrasenia") String contrasenia) {
            Consultas login = new Consultas();
            
            try {            
            return login.login(nickname, contrasenia);
        } catch (Exception e) {
            return false;
        }            
        }
    
    @WebMethod(operationName = "register")
    public boolean register(@WebParam(name = "nombre") String nombre,@WebParam(name = "correo") String correo,@WebParam(name = "fecha") String fecha ,@WebParam(name = "contrasenia") String contrasenia,@WebParam(name = "nickname") String nickname) {
            Consultas register = new Consultas();
            
            try {            
            return register.register(nombre, correo, fecha, contrasenia, nickname );
        } catch (Exception e) {
            return false;
        }            
        }
    
}
