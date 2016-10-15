package com.edu.eam.entidades;

import com.edu.eam.entidades.Mensaje;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-09T23:58:41")
@StaticMetamodel(MensajeTeletrim.class)
public class MensajeTeletrim_ { 

    public static volatile SingularAttribute<MensajeTeletrim, Date> fecha;
    public static volatile SingularAttribute<MensajeTeletrim, String> numeroAbonado;
    public static volatile SingularAttribute<MensajeTeletrim, Integer> id;
    public static volatile SingularAttribute<MensajeTeletrim, Mensaje> mensaje;

}