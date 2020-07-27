package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Menu;

public class MenuSqlProvider {

    public String insertSelective(Menu record) {
        BEGIN();
        INSERT_INTO("menu");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUrl() != null) {
            VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            VALUES("`path`", "#{path,jdbcType=VARCHAR}");
        }
        
        if (record.getComponent() != null) {
            VALUES("component", "#{component,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIconcls() != null) {
            VALUES("iconCls", "#{iconcls,jdbcType=VARCHAR}");
        }
        
        if (record.getKeepalive() != null) {
            VALUES("keepAlive", "#{keepalive,jdbcType=BIT}");
        }
        
        if (record.getRequireauth() != null) {
            VALUES("requireAuth", "#{requireauth,jdbcType=BIT}");
        }
        
        if (record.getParentid() != null) {
            VALUES("parentId", "#{parentid,jdbcType=INTEGER}");
        }
        
        if (record.getEnabled() != null) {
            VALUES("enabled", "#{enabled,jdbcType=BIT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Menu record) {
        BEGIN();
        UPDATE("menu");
        
        if (record.getUrl() != null) {
            SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            SET("`path` = #{path,jdbcType=VARCHAR}");
        }
        
        if (record.getComponent() != null) {
            SET("component = #{component,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIconcls() != null) {
            SET("iconCls = #{iconcls,jdbcType=VARCHAR}");
        }
        
        if (record.getKeepalive() != null) {
            SET("keepAlive = #{keepalive,jdbcType=BIT}");
        }
        
        if (record.getRequireauth() != null) {
            SET("requireAuth = #{requireauth,jdbcType=BIT}");
        }
        
        if (record.getParentid() != null) {
            SET("parentId = #{parentid,jdbcType=INTEGER}");
        }
        
        if (record.getEnabled() != null) {
            SET("enabled = #{enabled,jdbcType=BIT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}