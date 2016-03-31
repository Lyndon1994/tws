package xidian.tws.dao;



import xidian.common.dao.BaseDao;
import xidian.tws.entity.CompanyEntity;
import xidian.tws.entity.EmployeeEntity;
import xidian.tws.entity.EmployeerequestEntity;

import java.util.List;

/**
 * 瀛愬叕鍙告暟鎹鐞嗘帴鍙�
 * Created by wuhul on 2016/3/28.
 */
public interface EmployeerequestDao extends BaseDao<EmployeerequestEntity> {
    /**
     * 找出员工所有申请
     * @param employee
     * @return
     */
    public List<EmployeerequestEntity> findAllRequest(EmployeeEntity employee);

    /**
     * 找出公司所有申请
     * @param company
     * @return
     */
    List<EmployeerequestEntity> findAllRequest(CompanyEntity company);
}
