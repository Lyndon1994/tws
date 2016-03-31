package xidian.common.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 所有DAO组件的基类接口
 * Created by wuhul on 2016/3/27.
 */
public interface BaseDao<T> {
    //根据ID加载实体
    T get(Class<T> entityClazz, Serializable id);

    //保存实体
    Serializable save(T entity);

    //更新实体
    void update(T entity);

    //删除实体
    void delete(T entity);

    //删除所有实体
    void delete(Class<T> entityClazz, Serializable id);

    //获取所有实体
    List<T> findAll(Class<T> entityClazz);

    //获取所有实体总数
    long findCount(Class<T> entityClazz);
}
