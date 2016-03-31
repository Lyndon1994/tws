package xidian.tws.dao.impl;

import xidian.common.dao.impl.BaseDaoHibernate4;
import xidian.tws.dao.EmployeeDao;
import xidian.tws.entity.EmployeeEntity;
import xidian.tws.entity.ToolEntity;
import xidian.tws.entity.ToolStatus;

import java.util.List;

/**
 * Created by wuhul on 2016/3/28.
 */
public class EmployeeDaoImpl extends BaseDaoHibernate4<EmployeeEntity> implements EmployeeDao {
    /**
     * 根据用户名和密码查询员工
     *
     * @param name     员工的用户名
     * @param password 员工的密码
     * @return 符合用户名的员工
     */
    @Override
    public EmployeeEntity findByName(String name, String password) {
        List<EmployeeEntity> employee = find("select e from EmployeeEntity e where e.name = ?0 and e.password = ?1",name,password);
        if (employee!= null && employee.size() >= 1)
        {
            return employee.get(0);
        }
        return null;
    }

    /**
     * 增加员工的工具
     *
     * @param employee
     * @param tool
     * @return
     */
    @Override
    public boolean addTool(EmployeeEntity employee, ToolEntity tool) {
        if(!employee.getTools().contains(tool)) {
            employee.getTools().add(tool);
            tool.setEmployee(employee);
            return true;
        }
        return false;
    }

    /**
     * 移除员工的工具
     *
     * @param employee
     * @param tool
     * @return
     */
    @Override
    public boolean removeTool(EmployeeEntity employee, ToolEntity tool) {
        if(employee.getTools().contains(tool)) {
            employee.getTools().remove(tool);
            tool.setEmployee(null);
            return true;
        }
        return false;
    }

    /**
     * 找出员工自己借出的工具
     *
     * @param employee
     * @return
     */
    @Override
    public List<ToolEntity> getSelfTools(EmployeeEntity employee) {
        List<ToolEntity> list = employee.getTools();
        for (ToolEntity tool : list) {
            if(tool.getStatus().equals(ToolStatus.预约中))
                list.remove(tool);
        }
        return list;
    }
}
