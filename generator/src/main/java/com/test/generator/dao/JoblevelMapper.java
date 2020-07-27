package com.test.generator.dao;

import com.test.generator.entity.Joblevel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface JoblevelMapper {
    @Delete({
        "delete from joblevel",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into joblevel (id, `name`, ",
        "titleLevel, createDate, ",
        "enabled)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{titlelevel,jdbcType=CHAR}, #{createdate,jdbcType=TIMESTAMP}, ",
        "#{enabled,jdbcType=BIT})"
    })
    int insert(Joblevel record);

    @InsertProvider(type=JoblevelSqlProvider.class, method="insertSelective")
    int insertSelective(Joblevel record);

    @Select({
        "select",
        "id, `name`, titleLevel, createDate, enabled",
        "from joblevel",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="titleLevel", property="titlelevel", jdbcType=JdbcType.CHAR),
        @Result(column="createDate", property="createdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT)
    })
    Joblevel selectByPrimaryKey(Integer id);

    @UpdateProvider(type=JoblevelSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Joblevel record);

    @Update({
        "update joblevel",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "titleLevel = #{titlelevel,jdbcType=CHAR},",
          "createDate = #{createdate,jdbcType=TIMESTAMP},",
          "enabled = #{enabled,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Joblevel record);
}