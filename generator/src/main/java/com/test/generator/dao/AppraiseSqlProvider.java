package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Appraise;

public class AppraiseSqlProvider {

    public String insertSelective(Appraise record) {
        BEGIN();
        INSERT_INTO("appraise");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getEid() != null) {
            VALUES("eid", "#{eid,jdbcType=INTEGER}");
        }
        
        if (record.getAppdate() != null) {
            VALUES("appDate", "#{appdate,jdbcType=DATE}");
        }
        
        if (record.getAppresult() != null) {
            VALUES("appResult", "#{appresult,jdbcType=VARCHAR}");
        }
        
        if (record.getAppcontent() != null) {
            VALUES("appContent", "#{appcontent,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Appraise record) {
        BEGIN();
        UPDATE("appraise");
        
        if (record.getEid() != null) {
            SET("eid = #{eid,jdbcType=INTEGER}");
        }
        
        if (record.getAppdate() != null) {
            SET("appDate = #{appdate,jdbcType=DATE}");
        }
        
        if (record.getAppresult() != null) {
            SET("appResult = #{appresult,jdbcType=VARCHAR}");
        }
        
        if (record.getAppcontent() != null) {
            SET("appContent = #{appcontent,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}