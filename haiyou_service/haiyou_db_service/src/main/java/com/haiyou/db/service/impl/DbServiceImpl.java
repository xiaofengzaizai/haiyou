package com.haiyou.db.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haiyou.db.dao.DbMapper;
import com.haiyou.db.pojo.Db;
import com.haiyou.db.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Db业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class DbServiceImpl implements DbService {

    @Autowired
    private DbMapper dbMapper;


    /**
     * Db条件+分页查询
     *
     * @param db   查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Db> findPage(Db db, int page, int size) {
        //分页
        PageHelper.startPage(page, size);
        //搜索条件构建
        Example example = createExample(db);
        //执行搜索
        return new PageInfo<Db>(dbMapper.selectByExample(example));
    }

    /**
     * Db分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Db> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<Db>(dbMapper.selectAll());
    }

    /**
     * Db条件查询
     *
     * @param db
     * @return
     */
    @Override
    public List<Db> findList(Db db) {
        //构建查询条件
        Example example = createExample(db);
        //根据构建的条件查询数据
        return dbMapper.selectByExample(example);
    }


    /**
     * Db构建查询对象
     *
     * @param db
     * @return
     */
    public Example createExample(Db db) {
        Example example = new Example(Db.class);
        Example.Criteria criteria = example.createCriteria();
        if (db != null) {
            // 
            if (!StringUtils.isEmpty(db.getId())) {
                criteria.andEqualTo("id", db.getId());
            }
            // 
            if (!StringUtils.isEmpty(db.getCompanyName())) {
                criteria.andEqualTo("companyName", db.getCompanyName());
            }
            // 
            if (!StringUtils.isEmpty(db.getSampleName())) {
                criteria.andEqualTo("sampleName", db.getSampleName());
            }
            // 
            if (!StringUtils.isEmpty(db.getValue())) {
                criteria.andEqualTo("value", db.getValue());
            }
            // 
            if (!StringUtils.isEmpty(db.getRemark())) {
                criteria.andEqualTo("remark", db.getRemark());
            }
            // 
            if (!StringUtils.isEmpty(db.getAddTime())) {
                criteria.andEqualTo("addTime", db.getAddTime());
            }
            // 
            if (!StringUtils.isEmpty(db.getUpdateTime())) {
                criteria.andEqualTo("updateTime", db.getUpdateTime());
            }
            // 
            if (!StringUtils.isEmpty(db.getUnit())) {
                criteria.andEqualTo("unit", db.getUnit());
            }
        }
        return example;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        dbMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Db
     *
     * @param db
     */
    @Override
    public void update(Db db) {
        Integer id = db.getId();
        Db originDb = dbMapper.selectByPrimaryKey(id);
        String addTime = originDb.getAddTime();
        db.setAddTime(addTime);
        String updateTime = db.getUpdateTime();
        if (StringUtils.isEmpty(updateTime)) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String formatTime = df.format(new Date());
            db.setUpdateTime(formatTime);
        }
        dbMapper.updateByPrimaryKey(db);
    }

    /**
     * 增加Db
     *
     * @param db
     */
    @Override
    public void add(Db db) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String formatTime = df.format(new Date());
        if (StringUtils.isEmpty(db.getAddTime())){
            db.setAddTime(formatTime);
        }
        if (StringUtils.isEmpty(db.getUpdateTime())){
            db.setUpdateTime(formatTime);
        }
        dbMapper.insert(db);
    }

    /**
     * 根据ID查询Db
     *
     * @param id
     * @return
     */
    @Override
    public Db findById(Integer id) {
        return dbMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Db全部数据
     *
     * @return
     */
    @Override
    public List<Db> findAll() {
        return dbMapper.selectAll();
    }
}
