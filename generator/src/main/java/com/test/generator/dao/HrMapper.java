package com.test.generator.dao;

import com.test.generator.entity.Hr;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface HrMapper {
    @Delete({
        "delete from hr",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hr (id, `name`, ",
        "phone, telephone, address, ",
        "enabled, username, `password`, ",
        "userface, remark)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=CHAR}, #{telephone,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{enabled,jdbcType=BIT}, #{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{userface,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(Hr record);

    @InsertProvider(type=HrSqlProvider.class, method="insertSelective")
    int insertSelective(Hr record);

    @Select({
        "select",
        "id, `name`, phone, telephone, address, enabled, username, `password`, userface, ",
        "remark",
        "from hr",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="userface", property="userface", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    Hr selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HrSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Hr record);

    @Update({
        "update hr",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=CHAR},",
          "telephone = #{telephone,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "enabled = #{enabled,jdbcType=BIT},",
          "username = #{username,jdbcType=VARCHAR},",
          "`password` = #{password,jdbcType=VARCHAR},",
          "userface = #{userface,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Hr record);
}