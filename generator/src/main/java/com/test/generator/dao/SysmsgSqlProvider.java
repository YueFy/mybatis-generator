package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Sysmsg;

public class SysmsgSqlProvider {

    public String insertSelective(Sysmsg record) {
        BEGIN();
        INSERT_INTO("sysmsg");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getMid() != null) {
            VALUES("mid", "#{mid,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            VALUES("`type`", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getHrid() != null) {
            VALUES("hrid", "#{hrid,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            VALUES("`state`", "#{state,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Sysmsg record) {
        BEGIN();
        UPDATE("sysmsg");
        
        if (record.getMid() != null) {
            SET("mid = #{mid,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            SET("`type` = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getHrid() != null) {
            SET("hrid = #{hrid,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            SET("`state` = #{state,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}