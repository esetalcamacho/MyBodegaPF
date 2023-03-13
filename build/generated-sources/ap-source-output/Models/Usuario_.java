package Models;

import Models.Registro;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-19T18:51:56")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> usuNombre;
    public static volatile CollectionAttribute<Usuario, Registro> registroCollection;
    public static volatile SingularAttribute<Usuario, String> usuContraseña;
    public static volatile SingularAttribute<Usuario, String> usuEmail;
    public static volatile SingularAttribute<Usuario, String> usuIdentificacion;
    public static volatile SingularAttribute<Usuario, String> usuApellido;

}