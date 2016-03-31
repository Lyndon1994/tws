package xidian.tws.dao;



import xidian.common.dao.BaseDao;
import xidian.tws.entity.EmployeeEntity;
import xidian.tws.entity.LendEntity;

import java.util.List;

/**
 * 租借工具数据操作接口
 * Created by wuhul on 2016/3/28.
 */
public interface LendDao extends BaseDao<LendEntity> {
    /**
     * 根据员工ID查找所借工具借还记录
     * @param empId 员工ID
     * @return 所借工具
     */
    public List<LendEntity> findByEmpId(int empId);

    /**
     * 根据员工找到指定工具借还记录
     * @param employee
     * @param toolName
     * @return
     */
    public List<LendEntity> findLend(EmployeeEntity employee, String toolName);


}
