package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Employee;

public class EmployeeSqlProvider {

    public String insertSelective(Employee record) {
        BEGIN();
        INSERT_INTO("employee");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            VALUES("gender", "#{gender,jdbcType=CHAR}");
        }
        
        if (record.getBirthday() != null) {
            VALUES("birthday", "#{birthday,jdbcType=DATE}");
        }
        
        if (record.getIdcard() != null) {
            VALUES("idCard", "#{idcard,jdbcType=CHAR}");
        }
        
        if (record.getWedlock() != null) {
            VALUES("wedlock", "#{wedlock,jdbcType=CHAR}");
        }
        
        if (record.getNationid() != null) {
            VALUES("nationId", "#{nationid,jdbcType=INTEGER}");
        }
        
        if (record.getNativeplace() != null) {
            VALUES("nativePlace", "#{nativeplace,jdbcType=VARCHAR}");
        }
        
        if (record.getPoliticid() != null) {
            VALUES("politicId", "#{politicid,jdbcType=INTEGER}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartmentid() != null) {
            VALUES("departmentId", "#{departmentid,jdbcType=INTEGER}");
        }
        
        if (record.getJoblevelid() != null) {
            VALUES("jobLevelId", "#{joblevelid,jdbcType=INTEGER}");
        }
        
        if (record.getPosid() != null) {
            VALUES("posId", "#{posid,jdbcType=INTEGER}");
        }
        
        if (record.getEngageform() != null) {
            VALUES("engageForm", "#{engageform,jdbcType=VARCHAR}");
        }
        
        if (record.getTiptopdegree() != null) {
            VALUES("tiptopDegree", "#{tiptopdegree,jdbcType=CHAR}");
        }
        
        if (record.getSpecialty() != null) {
            VALUES("specialty", "#{specialty,jdbcType=VARCHAR}");
        }
        
        if (record.getSchool() != null) {
            VALUES("school", "#{school,jdbcType=VARCHAR}");
        }
        
        if (record.getBegindate() != null) {
            VALUES("beginDate", "#{begindate,jdbcType=DATE}");
        }
        
        if (record.getWorkstate() != null) {
            VALUES("workState", "#{workstate,jdbcType=CHAR}");
        }
        
        if (record.getWorkid() != null) {
            VALUES("workID", "#{workid,jdbcType=CHAR}");
        }
        
        if (record.getContractterm() != null) {
            VALUES("contractTerm", "#{contractterm,jdbcType=DOUBLE}");
        }
        
        if (record.getConversiontime() != null) {
            VALUES("conversionTime", "#{conversiontime,jdbcType=DATE}");
        }
        
        if (record.getNotworkdate() != null) {
            VALUES("notWorkDate", "#{notworkdate,jdbcType=DATE}");
        }
        
        if (record.getBegincontract() != null) {
            VALUES("beginContract", "#{begincontract,jdbcType=DATE}");
        }
        
        if (record.getEndcontract() != null) {
            VALUES("endContract", "#{endcontract,jdbcType=DATE}");
        }
        
        if (record.getWorkage() != null) {
            VALUES("workAge", "#{workage,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Employee record) {
        BEGIN();
        UPDATE("employee");
        
        if (record.getName() != null) {
            SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("gender = #{gender,jdbcType=CHAR}");
        }
        
        if (record.getBirthday() != null) {
            SET("birthday = #{birthday,jdbcType=DATE}");
        }
        
        if (record.getIdcard() != null) {
            SET("idCard = #{idcard,jdbcType=CHAR}");
        }
        
        if (record.getWedlock() != null) {
            SET("wedlock = #{wedlock,jdbcType=CHAR}");
        }
        
        if (record.getNationid() != null) {
            SET("nationId = #{nationid,jdbcType=INTEGER}");
        }
        
        if (record.getNativeplace() != null) {
            SET("nativePlace = #{nativeplace,jdbcType=VARCHAR}");
        }
        
        if (record.getPoliticid() != null) {
            SET("politicId = #{politicid,jdbcType=INTEGER}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartmentid() != null) {
            SET("departmentId = #{departmentid,jdbcType=INTEGER}");
        }
        
        if (record.getJoblevelid() != null) {
            SET("jobLevelId = #{joblevelid,jdbcType=INTEGER}");
        }
        
        if (record.getPosid() != null) {
            SET("posId = #{posid,jdbcType=INTEGER}");
        }
        
        if (record.getEngageform() != null) {
            SET("engageForm = #{engageform,jdbcType=VARCHAR}");
        }
        
        if (record.getTiptopdegree() != null) {
            SET("tiptopDegree = #{tiptopdegree,jdbcType=CHAR}");
        }
        
        if (record.getSpecialty() != null) {
            SET("specialty = #{specialty,jdbcType=VARCHAR}");
        }
        
        if (record.getSchool() != null) {
            SET("school = #{school,jdbcType=VARCHAR}");
        }
        
        if (record.getBegindate() != null) {
            SET("beginDate = #{begindate,jdbcType=DATE}");
        }
        
        if (record.getWorkstate() != null) {
            SET("workState = #{workstate,jdbcType=CHAR}");
        }
        
        if (record.getWorkid() != null) {
            SET("workID = #{workid,jdbcType=CHAR}");
        }
        
        if (record.getContractterm() != null) {
            SET("contractTerm = #{contractterm,jdbcType=DOUBLE}");
        }
        
        if (record.getConversiontime() != null) {
            SET("conversionTime = #{conversiontime,jdbcType=DATE}");
        }
        
        if (record.getNotworkdate() != null) {
            SET("notWorkDate = #{notworkdate,jdbcType=DATE}");
        }
        
        if (record.getBegincontract() != null) {
            SET("beginContract = #{begincontract,jdbcType=DATE}");
        }
        
        if (record.getEndcontract() != null) {
            SET("endContract = #{endcontract,jdbcType=DATE}");
        }
        
        if (record.getWorkage() != null) {
            SET("workAge = #{workage,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}