package xidian.tws.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created by wuhul on 2016/3/21.
 */
@Entity
@Table(name = "department", schema = "tws2")
public class DepartmentEntity {
    @Id
    @Column(name = "DEPARTMENT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "NAME", nullable = true, length = 255)
    private String name;

    @ManyToOne(targetEntity = CompanyEntity.class)
    @JoinColumn(name = "COMPANY_ID",nullable = false)
    @Cascade(CascadeType.ALL)/*此实体的所有持久化操作都会级联到它关联的实体*/
    private CompanyEntity company;


    public DepartmentEntity(int id, String name, CompanyEntity company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public DepartmentEntity() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return  name + '\'' +
                " 公司:" + company;
    }
}
