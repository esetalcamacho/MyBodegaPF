package Models;

import Models.Inventario;
import Models.Ventas;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-19T18:51:56")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, BigDecimal> proPrecio;
    public static volatile SingularAttribute<Productos, String> proStatus;
    public static volatile SingularAttribute<Productos, Integer> idProductos;
    public static volatile SingularAttribute<Productos, String> proNombre;
    public static volatile CollectionAttribute<Productos, Ventas> ventasCollection;
    public static volatile SingularAttribute<Productos, String> proUnidadMedida;
    public static volatile CollectionAttribute<Productos, Inventario> inventarioCollection;
    public static volatile SingularAttribute<Productos, Integer> proCantidad;
    public static volatile SingularAttribute<Productos, String> proObservaciones;

}