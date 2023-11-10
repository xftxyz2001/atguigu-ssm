package generator.mapper;

import generator.com.atguigu.pojo.Teacher;

/**
* @author Jackiechan
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2023-07-30 16:11:06
* @Entity generator.com.atguigu.pojo.Teacher
*/
public interface TeacherMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    //声明多表查询即可

}
