package Model;

import Model.Leitura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-24T21:56:17")
@StaticMetamodel(Sensor.class)
public class Sensor_ { 

    public static volatile ListAttribute<Sensor, Leitura> leituraList;
    public static volatile SingularAttribute<Sensor, String> nomeSensor;
    public static volatile SingularAttribute<Sensor, Integer> idSensor;
    public static volatile SingularAttribute<Sensor, String> descricao;

}