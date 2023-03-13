package Models;

import Models.Ventas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-19T18:51:56")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> cliNombre;
    public static volatile SingularAttribute<Clientes, String> cliDireccion;
    public static volatile CollectionAttribute<Clientes, Ventas> ventasCollection;
    public static volatile SingularAttribute<Clientes, String> cliTelefon;
    public static volatile SingularAttribute<Clientes, Integer> idClientes;
    public static volatile SingularAttribute<Clientes, String> cliCiudad;

}