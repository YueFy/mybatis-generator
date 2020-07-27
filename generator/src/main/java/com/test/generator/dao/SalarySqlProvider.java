package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Salary;

public class SalarySqlProvider {

    public String insertSelective(Salary record) {
        BEGIN();
        INSERT_INTO("salary");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getBasicsalary() != null) {
            VALUES("basicSalary", "#{basicsalary,jdbcType=INTEGER}");
        }
        
        if (record.getBonus() != null) {
            VALUES("bonus", "#{bonus,jdbcType=INTEGER}");
        }
        
        if (record.getLunchsalary() != null) {
            VALUES("lunchSalary", "#{lunchsalary,jdbcType=INTEGER}");
        }
        
        if (record.getTrafficsalary() != null) {
            VALUES("trafficSalary", "#{trafficsalary,jdbcType=INTEGER}");
        }
        
        if (record.getAllsalary() != null) {
            VALUES("allSalary", "#{allsalary,jdbcType=INTEGER}");
        }
        
        if (record.getPensionbase() != null) {
            VALUES("pensionBase", "#{pensionbase,jdbcType=INTEGER}");
        }
        
        if (record.getPensionper() != null) {
            VALUES("pensionPer", "#{pensionper,jdbcType=REAL}");
        }
        
        if (record.getCreatedate() != null) {
            VALUES("createDate", "#{createdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMedicalbase() != null) {
            VALUES("medicalBase", "#{medicalbase,jdbcType=INTEGER}");
        }
        
        if (record.getMedicalper() != null) {
            VALUES("medicalPer", "#{medicalper,jdbcType=REAL}");
        }
        
        if (record.getAccumulationfundbase() != null) {
            VALUES("accumulationFundBase", "#{accumulationfundbase,jdbcType=INTEGER}");
        }
        
        if (record.getAccumulationfundper() != null) {
            VALUES("accumulationFundPer", "#{accumulationfundper,jdbcType=REAL}");
        }
        
        if (record.getName() != null) {
            VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Salary record) {
        BEGIN();
        UPDATE("salary");
        
        if (record.getBasicsalary() != null) {
            SET("basicSalary = #{basicsalary,jdbcType=INTEGER}");
        }
        
        if (record.getBonus() != null) {
            SET("bonus = #{bonus,jdbcType=INTEGER}");
        }
        
        if (record.getLunchsalary() != null) {
            SET("lunchSalary = #{lunchsalary,jdbcType=INTEGER}");
        }
        
        if (record.getTrafficsalary() != null) {
            SET("trafficSalary = #{trafficsalary,jdbcType=INTEGER}");
        }
        
        if (record.getAllsalary() != null) {
            SET("allSalary = #{allsalary,jdbcType=INTEGER}");
        }
        
        if (record.getPensionbase() != null) {
            SET("pensionBase = #{pensionbase,jdbcType=INTEGER}");
        }
        
        if (record.getPensionper() != null) {
            SET("pensionPer = #{pensionper,jdbcType=REAL}");
        }
        
        if (record.getCreatedate() != null) {
            SET("createDate = #{createdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMedicalbase() != null) {
            SET("medicalBase = #{medicalbase,jdbcType=INTEGER}");
        }
        
        if (record.getMedicalper() != null) {
            SET("medicalPer = #{medicalper,jdbcType=REAL}");
        }
        
        if (record.getAccumulationfundbase() != null) {
            SET("accumulationFundBase = #{accumulationfundbase,jdbcType=INTEGER}");
        }
        
        if (record.getAccumulationfundper() != null) {
            SET("accumulationFundPer = #{accumulationfundper,jdbcType=REAL}");
        }
        
        if (record.getName() != null) {
            SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}