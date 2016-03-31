package xidian.tws.entity;

import javax.persistence.*;

/**
 * Created by wuhul on 2016/3/21.
 */
@Entity
@Table(name = "company", schema = "tws2")
public class CompanyEntity {
    @Id
    @Column(name = "COMPANY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "NAME", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "LOCATION", nullable = true, length = 255)
    private String location;

    public CompanyEntity() {
    }

    public CompanyEntity(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyEntity that = (CompanyEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
