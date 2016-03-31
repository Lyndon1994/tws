package xidian.tws.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wuhul on 2016/3/21.
 */
@Entity
@Table(name = "employeerequest", schema = "tws2")
public class EmployeerequestEntity{

    @Id
    @Column(name = "REQUEST_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = EmployeeEntity.class)
    @JoinColumn(name = "EMPLOYEE_ID",nullable = false)
    private EmployeeEntity employee;

    @ManyToOne(targetEntity = ToolEntity.class)
    @JoinColumn(name = "TOOL_ID",nullable = false)
    private ToolEntity tool;

    @Basic
    @Column(name = "REQUEST_STATUS", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private QuestStatus status=QuestStatus.审核中;

    @Basic
    @Column(name = "REQUEST_TIME", nullable = true)
    private Date time;

    public EmployeerequestEntity() {
    }

    public EmployeerequestEntity(EmployeeEntity employee, ToolEntity tool, Date time) {
        this.employee = employee;
        this.tool = tool;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public ToolEntity getTool() {
        return tool;
    }

    public void setTool(ToolEntity tool) {
        this.tool = tool;
    }

    public QuestStatus getStatus() {
        return status;
    }
    public void setStatus(QuestStatus status) {
        this.status = status;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeerequestEntity that = (EmployeerequestEntity) o;

        if (id != that.id) return false;
        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;
        if (tool != null ? !tool.equals(that.tool) : that.tool != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + (tool != null ? tool.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }


}

