package Models;

import Models.Inventario;
import Models.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-19T18:51:56")
@StaticMetamodel(Registro.class)
public class Registro_ { 

    public static volatile SingularAttribute<Registro, Usuario> fkIdentificacion;
    public static volatile SingularAttribute<Registro, String> regUserID;
    public static volatile SingularAttribute<Registro, String> regRol;
    public static volatile CollectionAttribute<Registro, Inventario> inventarioCollection;

}