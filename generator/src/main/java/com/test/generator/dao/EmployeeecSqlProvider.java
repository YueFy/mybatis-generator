package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Employeeec;

public class EmployeeecSqlProvider {

    public String insertSelective(Employeeec record) {
        BEGIN();
        INSERT_INTO("employeeec");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getEid() != null) {
            VALUES("eid", "#{eid,jdbcType=INTEGER}");
        }
        
        if (record.getEcdate() != null) {
            VALUES("ecDate", "#{ecdate,jdbcType=DATE}");
        }
        
        if (record.getEcreason() != null) {
            VALUES("ecReason", "#{ecreason,jdbcType=VARCHAR}");
        }
        
        if (record.getEcpoint() != null) {
            VALUES("ecPoint", "#{ecpoint,jdbcType=INTEGER}");
        }
        
        if (record.getEctype() != null) {
            VALUES("ecType", "#{ectype,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Employeeec record) {
        BEGIN();
        UPDATE("employeeec");
        
        if (record.getEid() != null) {
            SET("eid = #{eid,jdbcType=INTEGER}");
        }
        
        if (record.getEcdate() != null) {
            SET("ecDate = #{ecdate,jdbcType=DATE}");
        }
        
        if (record.getEcreason() != null) {
            SET("ecReason = #{ecreason,jdbcType=VARCHAR}");
        }
        
        if (record.getEcpoint() != null) {
            SET("ecPoint = #{ecpoint,jdbcType=INTEGER}");
        }
        
        if (record.getEctype() != null) {
            SET("ecType = #{ectype,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}