package xidian.tws.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wuhul on 2016/3/21.
 */
@Entity
@Table(name = "lend", schema = "tws2")
public class LendEntity {
    @Id
    @Column(name = "LEND_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(targetEntity = ToolEntity.class)
    @JoinColumn(name = "TOOL_ID",nullable = false)
    private ToolEntity tool;

    @ManyToOne(targetEntity = EmployeeEntity.class)
    @JoinColumn(name = "EMPLOYEE_ID",nullable = false)
    private EmployeeEntity employee;
    @Basic
    @Column(name = "LEND_OPERATE", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private LendOperate operate;
    @Basic
    @Column(name = "LEND_TIME", nullable = true)
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ToolEntity getTool() {
        return tool;
    }

    public void setTool(ToolEntity tool) {
        this.tool = tool;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public LendOperate getOperate() {
        return operate;
    }

    public void setOperate(LendOperate operate) {
        this.operate = operate;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public LendEntity() {
    }

    public LendEntity(ToolEntity tool, EmployeeEntity employee, LendOperate operate, Date time) {
        this.tool = tool;
        this.employee = employee;
        this.operate = operate;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LendEntity that = (LendEntity) o;

        if (id != that.id) return false;
        if (tool != null ? !tool.equals(that.tool) : that.tool != null) return false;
        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;
        if (operate != null ? !operate.equals(that.operate) : that.operate != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tool != null ? tool.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + (operate != null ? operate.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }


}

