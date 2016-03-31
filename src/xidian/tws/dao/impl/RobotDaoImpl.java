package xidian.tws.dao.impl;

import xidian.common.dao.impl.BaseDaoHibernate4;
import xidian.tws.dao.RobotDao;
import xidian.tws.entity.CompanyEntity;
import xidian.tws.entity.RobotEntity;
import xidian.tws.entity.RobotStatus;

import java.util.List;

/**
 * 瀛愬叕鍙告暟鎹鐞�
 * Created by wuhul on 2016/3/28.
 */
public class RobotDaoImpl extends BaseDaoHibernate4<RobotEntity> implements RobotDao {
    /**
     * 查看是否有可用机器人，如果有，则将空闲的机器人选择一个置为忙
     *
     * @param company
     * @return
     */
    @Override
    public boolean work(CompanyEntity company) {
        List<RobotEntity> robotList = find("select r from RobotEntity r where r.status=?0 and r.company=?1",RobotStatus.空闲, company);
        if (robotList != null&&robotList.size()>0) {
            robotList.get(0).setStatus(RobotStatus.忙);
            return true;
        }
        return false;
    }

    /**
     * 空闲出一个机器人
     *
     * @param company
     */
    @Override
    public void free(CompanyEntity company) {
        List<RobotEntity> robotList = find("select r from RobotEntity r where r.status=?0 and r.company=?1",RobotStatus.忙, company);
        if (robotList != null&&robotList.size()>0) {
            robotList.get(0).setStatus(RobotStatus.空闲);
        }
    }

    /**
     * 找出公司所有机器人
     *
     * @param company
     * @return
     */
    @Override
    public List<RobotEntity> findAll(CompanyEntity company) {
        return find("select r from RobotEntity r where r.company=?0", company);
    }
}
