package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.FlywaySchemaHistory;

public class FlywaySchemaHistorySqlProvider {

    public String insertSelective(FlywaySchemaHistory record) {
        BEGIN();
        INSERT_INTO("flyway_schema_history");
        
        if (record.getInstalledRank() != null) {
            VALUES("installed_rank", "#{installedRank,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            VALUES("`type`", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getScript() != null) {
            VALUES("script", "#{script,jdbcType=VARCHAR}");
        }
        
        if (record.getChecksum() != null) {
            VALUES("`checksum`", "#{checksum,jdbcType=INTEGER}");
        }
        
        if (record.getInstalledBy() != null) {
            VALUES("installed_by", "#{installedBy,jdbcType=VARCHAR}");
        }
        
        if (record.getInstalledOn() != null) {
            VALUES("installed_on", "#{installedOn,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExecutionTime() != null) {
            VALUES("execution_time", "#{executionTime,jdbcType=INTEGER}");
        }
        
        if (record.getSuccess() != null) {
            VALUES("success", "#{success,jdbcType=BIT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(FlywaySchemaHistory record) {
        BEGIN();
        UPDATE("flyway_schema_history");
        
        if (record.getVersion() != null) {
            SET("version = #{version,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("`type` = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getScript() != null) {
            SET("script = #{script,jdbcType=VARCHAR}");
        }
        
        if (record.getChecksum() != null) {
            SET("`checksum` = #{checksum,jdbcType=INTEGER}");
        }
        
        if (record.getInstalledBy() != null) {
            SET("installed_by = #{installedBy,jdbcType=VARCHAR}");
        }
        
        if (record.getInstalledOn() != null) {
            SET("installed_on = #{installedOn,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExecutionTime() != null) {
            SET("execution_time = #{executionTime,jdbcType=INTEGER}");
        }
        
        if (record.getSuccess() != null) {
            SET("success = #{success,jdbcType=BIT}");
        }
        
        WHERE("installed_rank = #{installedRank,jdbcType=INTEGER}");
        
        return SQL();
    }
}