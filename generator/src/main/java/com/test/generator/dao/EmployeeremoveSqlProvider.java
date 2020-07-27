package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Employeeremove;

public class EmployeeremoveSqlProvider {

    public String insertSelective(Employeeremove record) {
        BEGIN();
        INSERT_INTO("employeeremove");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getEid() != null) {
            VALUES("eid", "#{eid,jdbcType=INTEGER}");
        }
        
        if (record.getAfterdepid() != null) {
            VALUES("afterDepId", "#{afterdepid,jdbcType=INTEGER}");
        }
        
        if (record.getAfterjobid() != null) {
            VALUES("afterJobId", "#{afterjobid,jdbcType=INTEGER}");
        }
        
        if (record.getRemovedate() != null) {
            VALUES("removeDate", "#{removedate,jdbcType=DATE}");
        }
        
        if (record.getReason() != null) {
            VALUES("reason", "#{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Employeeremove record) {
        BEGIN();
        UPDATE("employeeremove");
        
        if (record.getEid() != null) {
            SET("eid = #{eid,jdbcType=INTEGER}");
        }
        
        if (record.getAfterdepid() != null) {
            SET("afterDepId = #{afterdepid,jdbcType=INTEGER}");
        }
        
        if (record.getAfterjobid() != null) {
            SET("afterJobId = #{afterjobid,jdbcType=INTEGER}");
        }
        
        if (record.getRemovedate() != null) {
            SET("removeDate = #{removedate,jdbcType=DATE}");
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