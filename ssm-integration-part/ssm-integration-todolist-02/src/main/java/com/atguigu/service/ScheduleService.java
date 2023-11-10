package com.atguigu.service;

import com.atguigu.pojo.Schedule;
import com.atguigu.utils.R;

/**
 * projectName: com.atguigu.service
 *
 * @author: 赵伟风
 * description:
 */
public interface ScheduleService {
    R page(int pageSize, int currentPage);

    R remove(Integer id);

    R save(Schedule schedule);

    R update(Schedule schedule);
}
