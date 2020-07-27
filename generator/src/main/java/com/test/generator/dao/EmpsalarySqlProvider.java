package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Empsalary;

public class EmpsalarySqlProvider {

    public String insertSelective(Empsalary record) {
        BEGIN();
        INSERT_INTO("empsalary");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getEid() != null) {
            VALUES("eid", "#{eid,jdbcType=INTEGER}");
        }
        
        if (record.getSid() != null) {
            VALUES("sid", "#{sid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Empsalary record) {
        BEGIN();
        UPDATE("empsalary");
        
        if (record.getEid() != null) {
            SET("eid = #{eid,jdbcType=INTEGER}");
        }
        
        if (record.getSid() != null) {
            SET("sid = #{sid,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}