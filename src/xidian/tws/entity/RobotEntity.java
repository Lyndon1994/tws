package xidian.tws.entity;

import javax.persistence.*;

/**
 * Created by wuhul on 2016/3/21.
 */
@Entity
@Table(name = "robot", schema = "tws2")
public class RobotEntity {
    @Id
    @Column(name = "ROBOT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = CompanyEntity.class)
    @JoinColumn(name = "COMPANY_ID" ,nullable = false)
    private CompanyEntity company;

    @Basic
    @Column(name = "ROBOT_STATUS", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private RobotStatus status;

    public RobotEntity(CompanyEntity company, RobotStatus status) {
        this.company = company;
        this.status = status;
    }

    public RobotEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public RobotStatus getStatus() {
        return status;
    }

    public void setStatus(RobotStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RobotEntity that = (RobotEntity) o;

        if (id != that.id) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
