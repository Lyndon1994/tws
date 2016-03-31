package xidian.tws.dao.impl;

import xidian.common.dao.impl.BaseDaoHibernate4;
import xidian.tws.dao.ToolDao;
import xidian.tws.entity.*;

import java.util.List;

/**
 * Created by wuhul on 2016/3/28.
 */
public class ToolDaoImpl extends BaseDaoHibernate4<ToolEntity> implements ToolDao {
    /**
     * 更新工具状态为预约中
     *
     * @param employee
     * @param tool
     */
    @Override
    public void updatePre(EmployeeEntity employee, ToolEntity tool) {
        tool.setStatus(ToolStatus.预约中);
        tool.setEmployee(employee);
        update(tool);
    }

    /**
     * 找到部门所有工具
     *
     * @param department 部门
     * @return 部门所有工具
     */
    @Override
    public List<ToolEntity> findToolsByDepartment(DepartmentEntity department) {
        return find("select t from ToolEntity t where t.department = ?0",department);
    }

    /**
     * 找到公司所有工具
     * @param company 公司
     * @return 部门所有工具
     */
    @Override
    public List<ToolEntity> findCompanyTools(CompanyEntity company){
        return find("select t from ToolEntity t where t.department.company =?0",company);
    }
    /**
     * 找到所有工具
     *
     * @return 部门所有工具
     */
    @Override
    public List<ToolEntity> findAllTools() {
        return findAll(ToolEntity.class);
    }

    /**
     * 状态设为苦中
     *
     * @param tool
     */
    @Override
    public void updateReturn(ToolEntity tool) {
        tool.setStatus(ToolStatus.库中);
        tool.setEmployee(null);
        update(tool);
    }

    /**
     * 状态设为借出
     *
     * @param tool
     */
    @Override
    public void updateLend(ToolEntity tool) {
        tool.setStatus(ToolStatus.借出);
        update(tool);
    }

    /**
     * 状态设为注销
     *
     * @param tool
     */
    @Override
    public void updateCancel(ToolEntity tool) {
        tool.setStatus(ToolStatus.损坏);
        update(tool);
    }
}
