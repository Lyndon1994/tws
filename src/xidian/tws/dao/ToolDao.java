package xidian.tws.dao;

import xidian.common.dao.BaseDao;
import xidian.tws.entity.CompanyEntity;
import xidian.tws.entity.DepartmentEntity;
import xidian.tws.entity.EmployeeEntity;
import xidian.tws.entity.ToolEntity;

import java.util.List;

/**
 * 工具数据处理接口
 * Created by wuhul on 2016/3/28.
 */
public interface ToolDao extends BaseDao<ToolEntity> {
    /**
     * 更新工具状态为预约中
     *
     * @param employee
     * @param tool
     */
    public void updatePre(EmployeeEntity employee, ToolEntity tool);

    /**
     * 找到部门所有工具
     * @param department 部门
     * @return 部门所有工具
     */
    public List<ToolEntity> findToolsByDepartment(DepartmentEntity department);

    /**
     * 找到公司所有工具
     * @param company 公司
     * @return 部门所有工具
     */
    public List<ToolEntity> findCompanyTools(CompanyEntity company);

    /**
     * 找到所有工具
     * @return 部门所有工具
     */
    public List<ToolEntity> findAllTools();

    /**
     * 状态设为苦中
     * @param tool
     */
    void updateReturn(ToolEntity tool);

    /**
     * 状态设为借出
     * @param tool
     */
    void updateLend(ToolEntity tool);

    /**
     * 状态设为注销
     * @param tool
     */
    void updateCancel(ToolEntity tool);
}
