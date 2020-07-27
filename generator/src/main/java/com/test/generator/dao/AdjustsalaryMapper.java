package com.test.generator.dao;

import com.test.generator.entity.Adjustsalary;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AdjustsalaryMapper {
    @Delete({
        "delete from adjustsalary",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into adjustsalary (id, eid, ",
        "asDate, beforeSalary, ",
        "afterSalary, reason, ",
        "remark)",
        "values (#{id,jdbcType=INTEGER}, #{eid,jdbcType=INTEGER}, ",
        "#{asdate,jdbcType=DATE}, #{beforesalary,jdbcType=INTEGER}, ",
        "#{aftersalary,jdbcType=INTEGER}, #{reason,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(Adjustsalary record);

    @InsertProvider(type=AdjustsalarySqlProvider.class, method="insertSelective")
    int insertSelective(Adjustsalary record);

    @Select({
        "select",
        "id, eid, asDate, beforeSalary, afterSalary, reason, remark",
        "from adjustsalary",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eid", property="eid", jdbcType=JdbcType.INTEGER),
        @Result(column="asDate", property="asdate", jdbcType=JdbcType.DATE),
        @Result(column="beforeSalary", property="beforesalary", jdbcType=JdbcType.INTEGER),
        @Result(column="afterSalary", property="aftersalary", jdbcType=JdbcType.INTEGER),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    Adjustsalary selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AdjustsalarySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Adjustsalary record);

    @Update({
        "update adjustsalary",
        "set eid = #{eid,jdbcType=INTEGER},",
          "asDate = #{asdate,jdbcType=DATE},",
          "beforeSalary = #{beforesalary,jdbcType=INTEGER},",
          "afterSalary = #{aftersalary,jdbcType=INTEGER},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Adjustsalary record);
}