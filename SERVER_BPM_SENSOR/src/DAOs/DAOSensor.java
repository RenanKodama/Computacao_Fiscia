/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Model.Sensor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author geovani
 */
public class DAOSensor extends DAOGenerico<Sensor> {
    
    public DAOSensor() {
        super(Sensor.class);
    }
 
  public List<Sensor> lista(){
    Query query = em.createQuery("select s from Sensor s");
    return (List<Sensor>) query.getResultList();
  }
    
}
