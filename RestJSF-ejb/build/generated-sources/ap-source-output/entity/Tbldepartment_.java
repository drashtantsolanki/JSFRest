package entity;

import entity.Tblemployee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-02T18:31:06")
@StaticMetamodel(Tbldepartment.class)
public class Tbldepartment_ { 

    public static volatile SingularAttribute<Tbldepartment, String> departmentName;
    public static volatile CollectionAttribute<Tbldepartment, Tblemployee> tblemployeeCollection;
    public static volatile SingularAttribute<Tbldepartment, Integer> deptId;

}