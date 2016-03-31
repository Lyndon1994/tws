package xidian.tws.dao.impl;

import xidian.common.dao.impl.BaseDaoHibernate4;
import xidian.tws.dao.LendDao;
import xidian.tws.entity.EmployeeEntity;
import xidian.tws.entity.LendEntity;

import java.util.List;

/**
 * 瀛愬叕鍙告暟鎹鐞�
 * Created by wuhul on 2016/3/28.
 */
public class LendDaoImpl extends BaseDaoHibernate4<LendEntity> implements LendDao {
    /**
     * 根据员工ID查找所借工具
     *
     * @param empId 员工ID
     * @return 所借工具
     */
    @Override
    public List<LendEntity> findByEmpId(int empId) {
        List<LendEntity> list = find("select l from LendEntity l where l.employee.id = ?0",empId);
        return list;
    }

    /**
     * 根据员工找到指定工具借还记录
     *
     * @param employee
     * @param toolName
     * @return
     */
    @Override
    public List<LendEntity> findLend(EmployeeEntity employee, String toolName) {
        List<LendEntity> list = find("select l from LendEntity l where l.employee = ?0 and l.tool.name=?1",employee,toolName);
        return list;
    }


}
