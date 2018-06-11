/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import static DAOs.DAOGenerico.em;

import Model.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author geovani
 */
public class DAOUsuario extends DAOGenerico<Usuario> {
    
    public DAOUsuario() {
        super(Usuario.class);
    }

    @Override
    public void inserir(Usuario e) {
        super.inserir(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Usuario e) {
        super.remover(e); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public List<Usuario> list() {
        return super.list(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
//    public static List<Usuario> lista(){
//        
//    Query query = em.createQuery("select u from Usuario u");
//    return (List<Usuario>) query.getResultList();
  //}
    
    
}
