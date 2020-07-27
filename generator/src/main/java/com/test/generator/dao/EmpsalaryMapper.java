package com.test.generator.dao;

import com.test.generator.entity.Empsalary;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface EmpsalaryMapper {
    @Delete({
        "delete from empsalary",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into empsalary (id, eid, ",
        "sid)",
        "values (#{id,jdbcType=INTEGER}, #{eid,jdbcType=INTEGER}, ",
        "#{sid,jdbcType=INTEGER})"
    })
    int insert(Empsalary record);

    @InsertProvider(type=EmpsalarySqlProvider.class, method="insertSelective")
    int insertSelective(Empsalary record);

    @Select({
        "select",
        "id, eid, sid",
        "from empsalary",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eid", property="eid", jdbcType=JdbcType.INTEGER),
        @Result(column="sid", property="sid", jdbcType=JdbcType.INTEGER)
    })
    Empsalary selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EmpsalarySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Empsalary record);

    @Update({
        "update empsalary",
        "set eid = #{eid,jdbcType=INTEGER},",
          "sid = #{sid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Empsalary record);
}