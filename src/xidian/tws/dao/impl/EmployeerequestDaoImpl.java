package xidian.tws.dao.impl;

import xidian.common.dao.impl.BaseDaoHibernate4;
import xidian.tws.dao.EmployeerequestDao;
import xidian.tws.entity.CompanyEntity;
import xidian.tws.entity.EmployeeEntity;
import xidian.tws.entity.EmployeerequestEntity;

import java.util.List;

/**
 * 瀛愬叕鍙告暟鎹鐞�
 * Created by wuhul on 2016/3/28.
 */
public class EmployeerequestDaoImpl extends BaseDaoHibernate4<EmployeerequestEntity> implements EmployeerequestDao {
    /**
     * 找出员工所有申请
     *
     * @param employee
     * @return
     */
    @Override
    public List<EmployeerequestEntity> findAllRequest(EmployeeEntity employee) {
        return find("select r from EmployeerequestEntity r where r.employee = ?0 ",employee);
    }

    /**
     * 找出公司所有申请
     *
     * @param company
     * @return
     */
    @Override
    public List<EmployeerequestEntity> findAllRequest(CompanyEntity company) {
        return find("select r from EmployeerequestEntity r where r.tool.department.company = ?0 ",company);
    }
}
