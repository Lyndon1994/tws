package xidian.tws.dao;



import xidian.common.dao.BaseDao;
import xidian.tws.entity.CompanyEntity;
import xidian.tws.entity.RobotEntity;

import java.util.List;

/**
 * 瀛愬叕鍙告暟鎹鐞嗘帴鍙�
 * Created by wuhul on 2016/3/28.
 */
public interface RobotDao extends BaseDao<RobotEntity> {
    /**
     * 查看是否有可用机器人，如果有，则将空闲的机器人选择一个置为忙
     * @param company
     * @return
     */
    public boolean work(CompanyEntity company);

    /**
     * 空闲出一个机器人
     * @param company
     */
    public void free(CompanyEntity company);

    /**
     * 找出公司所有机器人
     * @param company
     * @return
     */
    List<RobotEntity> findAll(CompanyEntity company);
}
