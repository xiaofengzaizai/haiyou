package com.haiyou.db.service;


import com.github.pagehelper.PageInfo;
import com.haiyou.db.pojo.Db;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Db业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface DbService {

    /***
     * Db多条件分页查询
     * @param db
     * @param page
     * @param size
     * @return
     */
    PageInfo<Db> findPage(Db db, int page, int size);

    /***
     * Db分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Db> findPage(int page, int size);

    /***
     * Db多条件搜索方法
     * @param db
     * @return
     */
    List<Db> findList(Db db);

    /***
     * 删除Db
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Db数据
     * @param db
     */
    void update(Db db);

    /***
     * 新增Db
     * @param db
     */
    void add(Db db);

    /**
     * 根据ID查询Db
     * @param id
     * @return
     */
     Db findById(Integer id);

    /***
     * 查询所有Db
     * @return
     */
    List<Db> findAll();
}
