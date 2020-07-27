package com.test.generator.dao;

import com.test.generator.entity.Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MenuMapper {
    @Delete({
        "delete from menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into menu (id, url, ",
        "`path`, component, ",
        "`name`, iconCls, keepAlive, ",
        "requireAuth, parentId, ",
        "enabled)",
        "values (#{id,jdbcType=INTEGER}, #{url,jdbcType=VARCHAR}, ",
        "#{path,jdbcType=VARCHAR}, #{component,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{iconcls,jdbcType=VARCHAR}, #{keepalive,jdbcType=BIT}, ",
        "#{requireauth,jdbcType=BIT}, #{parentid,jdbcType=INTEGER}, ",
        "#{enabled,jdbcType=BIT})"
    })
    int insert(Menu record);

    @InsertProvider(type=MenuSqlProvider.class, method="insertSelective")
    int insertSelective(Menu record);

    @Select({
        "select",
        "id, url, `path`, component, `name`, iconCls, keepAlive, requireAuth, parentId, ",
        "enabled",
        "from menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="component", property="component", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="iconCls", property="iconcls", jdbcType=JdbcType.VARCHAR),
        @Result(column="keepAlive", property="keepalive", jdbcType=JdbcType.BIT),
        @Result(column="requireAuth", property="requireauth", jdbcType=JdbcType.BIT),
        @Result(column="parentId", property="parentid", jdbcType=JdbcType.INTEGER),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT)
    })
    Menu selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Menu record);

    @Update({
        "update menu",
        "set url = #{url,jdbcType=VARCHAR},",
          "`path` = #{path,jdbcType=VARCHAR},",
          "component = #{component,jdbcType=VARCHAR},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "iconCls = #{iconcls,jdbcType=VARCHAR},",
          "keepAlive = #{keepalive,jdbcType=BIT},",
          "requireAuth = #{requireauth,jdbcType=BIT},",
          "parentId = #{parentid,jdbcType=INTEGER},",
          "enabled = #{enabled,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Menu record);
}