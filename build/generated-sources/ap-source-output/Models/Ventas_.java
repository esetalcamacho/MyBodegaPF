package Models;

import Models.Clientes;
import Models.Inventario;
import Models.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-19T18:51:56")
@StaticMetamodel(Ventas.class)
public class Ventas_ { 

    public static volatile SingularAttribute<Ventas, Date> venFecha;
    public static volatile SingularAttribute<Ventas, String> venObservaciones;
    public static volatile SingularAttribute<Ventas, Inventario> fkBodega;
    public static volatile SingularAttribute<Ventas, Double> venPrecioTotal;
    public static volatile SingularAttribute<Ventas, String> venStatus;
    public static volatile SingularAttribute<Ventas, Clientes> fkClientes;
    public static volatile SingularAttribute<Ventas, Integer> idVentas;
    public static volatile SingularAttribute<Ventas, Productos> venProducto;

}