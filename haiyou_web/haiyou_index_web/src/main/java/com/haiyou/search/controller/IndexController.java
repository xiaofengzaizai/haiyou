package com.haiyou.search.controller;

import com.haiyou.db.feign.DbFeign;
import com.haiyou.db.pojo.Db;
import com.haiyou.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @ Author     ：qjf
 * @ Date       ：Created in 10:44 2019/11/5
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@RestController
@RequestMapping("/search")
@CrossOrigin
public class IndexController {
    @Autowired
    private DbFeign dbFeign;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.setViewName("test");
        return modelAndView;
    }
    @RequestMapping(value = "/data",method = RequestMethod.GET)
   public Result<List<Db>> dataInfo(){
        Result<List<Db>> result = dbFeign.findAll();
        return result;
    }

}
