package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.HrRole;

public class HrRoleSqlProvider {

    public String insertSelective(HrRole record) {
        BEGIN();
        INSERT_INTO("hr_role");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getHrid() != null) {
            VALUES("hrid", "#{hrid,jdbcType=INTEGER}");
        }
        
        if (record.getRid() != null) {
            VALUES("rid", "#{rid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(HrRole record) {
        BEGIN();
        UPDATE("hr_role");
        
        if (record.getHrid() != null) {
            SET("hrid = #{hrid,jdbcType=INTEGER}");
        }
        
        if (record.getRid() != null) {
            SET("rid = #{rid,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}