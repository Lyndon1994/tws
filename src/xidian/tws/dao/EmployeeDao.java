package xidian.tws.dao;

import xidian.common.dao.BaseDao;
import xidian.tws.entity.EmployeeEntity;
import xidian.tws.entity.ToolEntity;

import java.util.List;

/**
 * 员工数据处理接口
 * Created by wuhul on 2016/3/28.
 */
public interface EmployeeDao extends BaseDao<EmployeeEntity> {
    /**
     * 根据用户名和密码查询员工
     * @param name 员工的用户名
     * @param password 员工的密码
     * @return 符合用户名的员工
     */
    public EmployeeEntity findByName(String name ,String password);

    /**
     * 增加员工的工具
     * @param employee
     * @param tool
     * @return
     */
    boolean addTool(EmployeeEntity employee, ToolEntity tool);

    /**
     * 移除员工的工具
     * @param employee
     * @param tool
     * @return
     */
    boolean removeTool(EmployeeEntity employee, ToolEntity tool);

    /**
     * 找出员工自己借出的工具
     * @param employee
     * @return
     */
    List<ToolEntity> getSelfTools(EmployeeEntity employee);
}
