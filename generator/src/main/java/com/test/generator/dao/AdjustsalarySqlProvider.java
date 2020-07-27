package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Adjustsalary;

public class AdjustsalarySqlProvider {

    public String insertSelective(Adjustsalary record) {
        BEGIN();
        INSERT_INTO("adjustsalary");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getEid() != null) {
            VALUES("eid", "#{eid,jdbcType=INTEGER}");
        }
        
        if (record.getAsdate() != null) {
            VALUES("asDate", "#{asdate,jdbcType=DATE}");
        }
        
        if (record.getBeforesalary() != null) {
            VALUES("beforeSalary", "#{beforesalary,jdbcType=INTEGER}");
        }
        
        if (record.getAftersalary() != null) {
            VALUES("afterSalary", "#{aftersalary,jdbcType=INTEGER}");
        }
        
        if (record.getReason() != null) {
            VALUES("reason", "#{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Adjustsalary record) {
        BEGIN();
        UPDATE("adjustsalary");
        
        if (record.getEid() != null) {
            SET("eid = #{eid,jdbcType=INTEGER}");
        }
        
        if (record.getAsdate() != null) {
            SET("asDate = #{asdate,jdbcType=DATE}");
        }
        
        if (record.getBeforesalary() != null) {
            SET("beforeSalary = #{beforesalary,jdbcType=INTEGER}");
        }
        
        if (record.getAftersalary() != null) {
            SET("afterSalary = #{aftersalary,jdbcType=INTEGER}");
        }
        
        if (record.getReason() != null) {
            SET("reason = #{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}