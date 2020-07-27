package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.MenuRole;

public class MenuRoleSqlProvider {

    public String insertSelective(MenuRole record) {
        BEGIN();
        INSERT_INTO("menu_role");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getMid() != null) {
            VALUES("mid", "#{mid,jdbcType=INTEGER}");
        }
        
        if (record.getRid() != null) {
            VALUES("rid", "#{rid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(MenuRole record) {
        BEGIN();
        UPDATE("menu_role");
        
        if (record.getMid() != null) {
            SET("mid = #{mid,jdbcType=INTEGER}");
        }
        
        if (record.getRid() != null) {
            SET("rid = #{rid,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}