package Models;

import Models.Movimientos;
import Models.Productos;
import Models.Registro;
import Models.Ventas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-19T18:51:56")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, Registro> fkRegUserID;
    public static volatile SingularAttribute<Inventario, Integer> idBodega;
    public static volatile SingularAttribute<Inventario, Productos> fkProducto;
    public static volatile CollectionAttribute<Inventario, Ventas> ventasCollection;
    public static volatile SingularAttribute<Inventario, Movimientos> fkMovimientos;

}