package entity;

import entity.Tbldepartment;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-02T18:31:06")
@StaticMetamodel(Tblemployee.class)
public class Tblemployee_ { 

    public static volatile SingularAttribute<Tblemployee, String> name;
    public static volatile SingularAttribute<Tblemployee, Tbldepartment> deptId;
    public static volatile SingularAttribute<Tblemployee, Integer> id;
    public static volatile SingularAttribute<Tblemployee, Integer> salary;

}