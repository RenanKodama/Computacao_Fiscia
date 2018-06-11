package Model;

import Model.Leitura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-24T21:56:17")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> nomeUsuario;
    public static volatile SingularAttribute<Usuario, Integer> idade;
    public static volatile SingularAttribute<Usuario, Float> peso;
    public static volatile ListAttribute<Usuario, Leitura> leituraList;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;

}