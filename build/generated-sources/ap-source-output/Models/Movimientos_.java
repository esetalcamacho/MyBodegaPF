package Models;

import Models.Inventario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-19T18:51:56")
@StaticMetamodel(Movimientos.class)
public class Movimientos_ { 

    public static volatile SingularAttribute<Movimientos, Integer> idMovimientos;
    public static volatile SingularAttribute<Movimientos, Date> movFechaIngreso;
    public static volatile SingularAttribute<Movimientos, Date> movHora;
    public static volatile SingularAttribute<Movimientos, Integer> movCantidadSalida;
    public static volatile SingularAttribute<Movimientos, Integer> movCantidadIngreso;
    public static volatile CollectionAttribute<Movimientos, Inventario> inventarioCollection;
    public static volatile SingularAttribute<Movimientos, Date> movFechaSalida;

}