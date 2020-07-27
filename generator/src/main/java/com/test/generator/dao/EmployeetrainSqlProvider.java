package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Employeetrain;

public class EmployeetrainSqlProvider {

    public String insertSelective(Employeetrain record) {
        BEGIN();
        INSERT_INTO("employeetrain");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getEid() != null) {
            VALUES("eid", "#{eid,jdbcType=INTEGER}");
        }
        
        if (record.getTraindate() != null) {
            VALUES("trainDate", "#{traindate,jdbcType=DATE}");
        }
        
        if (record.getTraincontent() != null) {
            VALUES("trainContent", "#{traincontent,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Employeetrain record) {
        BEGIN();
        UPDATE("employeetrain");
        
        if (record.getEid() != null) {
            SET("eid = #{eid,jdbcType=INTEGER}");
        }
        
        if (record.getTraindate() != null) {
            SET("trainDate = #{traindate,jdbcType=DATE}");
        }
        
        if (record.getTraincontent() != null) {
            SET("trainContent = #{traincontent,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}