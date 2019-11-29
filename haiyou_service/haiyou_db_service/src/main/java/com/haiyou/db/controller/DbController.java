package com.haiyou.db.controller;


import com.github.pagehelper.PageInfo;
import com.haiyou.db.pojo.Db;
import com.haiyou.db.service.DbService;
import com.haiyou.entity.Result;
import com.haiyou.entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "DbController")
@RestController
@RequestMapping("/db")
@CrossOrigin
public class DbController {

    @Autowired
    private DbService dbService;

    /***
     * Db分页条件搜索实现
     * @param db
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Db条件分页查询",notes = "分页条件查询Db方法详情",tags = {"DbController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Db对象",value = "传入JSON数据",required = false) Db db, @PathVariable  int page, @PathVariable  int size){
        //调用DbService实现分页条件查询Db
        PageInfo<Db> pageInfo = dbService.findPage(db, page, size);
        return new Result( StatusCode.success,"查询成功",pageInfo);
    }

    /***
     * Db分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Db分页查询",notes = "分页查询Db方法详情",tags = {"DbController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用DbService实现分页查询Db
        PageInfo<Db> pageInfo = dbService.findPage(page, size);
        return new Result<PageInfo>(StatusCode.success,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param db
     * @return
     */
    @ApiOperation(value = "Db条件查询",notes = "条件查询Db方法详情",tags = {"DbController"})
    @PostMapping(value = "/search" )
    public Result<List<Db>> findList(@RequestBody(required = false) @ApiParam(name = "Db对象",value = "传入JSON数据",required = false) Db db){
        //调用DbService实现条件查询Db
        List<Db> list = dbService.findList(db);
        return new Result<List<Db>>(StatusCode.success,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Db根据ID删除",notes = "根据ID删除Db方法详情",tags = {"DbController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用DbService实现根据主键删除
        dbService.delete(id);
        return new Result(StatusCode.success,"删除成功",null);
    }

    /***
     * 修改Db数据
     * @param db
     * @param id
     * @return
     */
    @ApiOperation(value = "Db根据ID修改",notes = "根据ID修改Db方法详情",tags = {"DbController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Db对象",value = "传入JSON数据",required = false) Db db,@PathVariable Integer id){
        //设置主键值
        db.setId(id);
        //调用DbService实现修改Db
        dbService.update(db);
        return new Result(StatusCode.success,"修改成功",null);
    }

    /***
     * 新增Db数据
     * @param db
     * @return
     */
    @ApiOperation(value = "Db添加",notes = "添加Db方法详情",tags = {"DbController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Db对象",value = "传入JSON数据",required = true) Db db){
        //调用DbService实现添加Db
        dbService.add(db);
        return new Result(StatusCode.success,"添加成功",null);
    }

    /***
     * 根据ID查询Db数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Db根据ID查询",notes = "根据ID查询Db方法详情",tags = {"DbController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Db> findById(@PathVariable Integer id){
        //调用DbService实现根据主键查询Db
        Db db = dbService.findById(id);
        return new Result<Db>(StatusCode.success,"查询成功",db);
    }

    /***
     * 查询Db全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Db",notes = "查询所Db有方法详情",tags = {"DbController"})
    @GetMapping
    public Result<List<Db>> findAll(){
        //调用DbService实现查询所有Db
        List<Db> list = dbService.findAll();
        return new Result<List<Db>>( StatusCode.success,"查询成功",list) ;
    }
}
