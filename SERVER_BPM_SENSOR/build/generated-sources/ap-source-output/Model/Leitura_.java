package Model;

import Model.Sensor;
import Model.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-24T21:56:17")
@StaticMetamodel(Leitura.class)
public class Leitura_ { 

    public static volatile SingularAttribute<Leitura, Float> valorLeitura;
    public static volatile SingularAttribute<Leitura, Date> data;
    public static volatile SingularAttribute<Leitura, Usuario> usuarioidUsuario;
    public static volatile SingularAttribute<Leitura, Sensor> sensoridSensor;
    public static volatile SingularAttribute<Leitura, Integer> idLeitura;

}