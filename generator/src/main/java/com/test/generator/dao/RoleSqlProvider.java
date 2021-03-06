package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Role;

public class RoleSqlProvider {

    public String insertSelective(Role record) {
        BEGIN();
        INSERT_INTO("role");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getNamezh() != null) {
            VALUES("nameZh", "#{namezh,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Role record) {
        BEGIN();
        UPDATE("role");
        
        if (record.getName() != null) {
            SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getNamezh() != null) {
            SET("nameZh = #{namezh,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}