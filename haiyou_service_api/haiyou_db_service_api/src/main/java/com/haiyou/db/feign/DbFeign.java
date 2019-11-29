package com.haiyou.db.feign;

import com.haiyou.db.pojo.Db;
import com.haiyou.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ Author     ：qjf
 * @ Date       ：Created in 14:30 2019/11/27
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@FeignClient(name ="db")
@RequestMapping("/db")
public interface DbFeign {
    @GetMapping
    Result<List<Db>> findAll();
}
