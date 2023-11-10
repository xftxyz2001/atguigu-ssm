package com.atguigu.mapper;

import com.atguigu.pojo.Schedule;

import java.util.List;

/**
 * projectName: com.atguigu.mapper
 *
 * @author: 赵伟风
 * description:
 */
public interface ScheduleMapper {

    List<Schedule> queryList();

    int deleteById(Integer id);

    int insert(Schedule schedule);

    int update(Schedule schedule);
}
