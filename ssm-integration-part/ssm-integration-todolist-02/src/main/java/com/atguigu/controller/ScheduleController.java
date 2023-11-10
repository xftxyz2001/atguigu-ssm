package com.atguigu.controller;

import com.atguigu.pojo.Schedule;
import com.atguigu.service.ScheduleService;
import com.atguigu.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * projectName: com.atguigu
 *
 * @author: 赵伟风
 * description:
 */

@CrossOrigin //允许其他源访问我们的controller 浏览器大哥就不拦截了!
@RestController
@RequestMapping("schedule")
@Slf4j
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    //接收参数
    //响应结果 springmvc
    @GetMapping("/{pageSize}/{currentPage}")
    public R page(@PathVariable int pageSize,
                  @PathVariable int currentPage){

        R r = scheduleService.page(pageSize,currentPage);
        //sl4fj
        log.info("查询的数据为：{}",r);
        return r;
    }


    @DeleteMapping("/{id}")
    public R remove(@PathVariable Integer id){
        R r = scheduleService.remove(id);
        return r;
    }

    @PostMapping
    public R save(@Validated @RequestBody Schedule schedule, BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数为null,不能保存！");
        }
        R r = scheduleService.save(schedule);
        return r;
    }

    @PutMapping
    public R update(@Validated @RequestBody Schedule schedule, BindingResult result){
        if (result.hasErrors()){
            return R.fail("参数为null,不能修改！");
        }
        R r = scheduleService.update(schedule);
        return r;
    }


}
