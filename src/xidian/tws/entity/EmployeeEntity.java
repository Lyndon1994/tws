package xidian.tws.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuhul on 2016/3/21.
 */
@Entity
@Table(name = "employee", schema = "tws2")
public class EmployeeEntity {
    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "EMPLOYEE_NAME", nullable = true, length = 50)
    private String name;

    @Column(name = "PASSWORD", nullable = true, length = 50)
    private String password;

    @OneToMany(targetEntity = ToolEntity.class,cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinTable(name = "employee_tools"
            ,joinColumns = @JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "EMPLOYEE_ID")
            ,inverseJoinColumns = @JoinColumn(name = "TOOL_ID",referencedColumnName = "TOOL_ID"))
    private List<ToolEntity> tools = new ArrayList<>();

    @Basic
    @Column(name = "EMPLOYEE_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @ManyToOne(targetEntity = CompanyEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "COMPANY_ID",nullable = true)
    private CompanyEntity company;

    @ManyToOne(targetEntity = DepartmentEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT_ID",nullable = true)
    private DepartmentEntity department;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String name, String password) {
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ToolEntity> getTools() {
        return tools;
    }

    public void setTools(List<ToolEntity> tools) {
        this.tools = tools;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        String string = "ID:" + id + " 级别:" + employeeType.toString();
        if (department!=null&&!department.equals(""))
            string+=" 部门:" + department;
        if (company!=null&&!company.equals(""))
            string+=" 公司:" + company;
        return string;
    }
}
