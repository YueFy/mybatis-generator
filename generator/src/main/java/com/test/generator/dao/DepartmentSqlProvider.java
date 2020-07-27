package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Department;

public class DepartmentSqlProvider {

    public String insertSelective(Department record) {
        BEGIN();
        INSERT_INTO("department");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentid() != null) {
            VALUES("parentId", "#{parentid,jdbcType=INTEGER}");
        }
        
        if (record.getDeppath() != null) {
            VALUES("depPath", "#{deppath,jdbcType=VARCHAR}");
        }
        
        if (record.getEnabled() != null) {
            VALUES("enabled", "#{enabled,jdbcType=BIT}");
        }
        
        if (record.getIsparent() != null) {
            VALUES("isParent", "#{isparent,jdbcType=BIT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Department record) {
        BEGIN();
        UPDATE("department");
        
        if (record.getName() != null) {
            SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentid() != null) {
            SET("parentId = #{parentid,jdbcType=INTEGER}");
        }
        
        if (record.getDeppath() != null) {
            SET("depPath = #{deppath,jdbcType=VARCHAR}");
        }
        
        if (record.getEnabled() != null) {
            SET("enabled = #{enabled,jdbcType=BIT}");
        }
        
        if (record.getIsparent() != null) {
            SET("isParent = #{isparent,jdbcType=BIT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}