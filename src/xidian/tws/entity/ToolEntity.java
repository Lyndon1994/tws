package xidian.tws.entity;

import javax.persistence.*;

/**
 * Created by wuhul on 2016/3/21.
 */
@Entity
@Table(name = "tool", schema = "tws2")
public class ToolEntity {
    @Id
    @Column(name = "TOOL_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "TOOL_NAME", nullable = true)
    private String name;
    @ManyToOne(targetEntity = DepartmentEntity.class)
    @JoinColumn(name = "DEPARTMENT_ID",nullable = false)
    private DepartmentEntity department;

    @Basic
    @Column(name = "TOOL_STATUS", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    private ToolStatus status;

    @Basic
    @Column(name = "TOOL_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private ToolType toolType;

    @ManyToOne(targetEntity = EmployeeEntity.class)
    @JoinTable(name = "employee_tools"
    ,joinColumns = @JoinColumn(name = "TOOL_ID",referencedColumnName = "TOOL_ID")
    ,inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "EMPLOYEE_ID"))
    private EmployeeEntity employee;

    public ToolEntity(String name, DepartmentEntity department, ToolStatus status, EmployeeEntity employee) {
        this.name = name;
        this.department = department;
        this.status = status;
        this.employee = employee;
    }

    public ToolEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public ToolStatus getStatus() {
        return status;
    }

    public void setStatus(ToolStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public void setToolType(ToolType toolType) {
        this.toolType = toolType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToolEntity that = (ToolEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "ID:" + id +
                " 名称:'" + name +
                " 部门:" + department.getName() +
                " 状态:" + status.toString();
    }
}
