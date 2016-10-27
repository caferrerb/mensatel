/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.eam.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author MAO
 */
@Singleton
@Startup
public class MainPrueba {

    /**
     * @param args the command line arguments
     */
    @PostConstruct
    public  void main() {
        try {
            // TODO code application logic here
            
            String path = "planes/listar";
            String respuesta=HTTPUtil.doGetListar(path);
            
            
            
            System.out.println(respuesta);
            Plan p = new Plan();
            
            List<Plan> planes=p.planes();
            
            for (int i = 0; i < planes.size(); i++) {
                
                System.out.println("plan:" +planes.get(i).nombre);
                 System.out.println("valor:" +planes.get(i).valorplan);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
