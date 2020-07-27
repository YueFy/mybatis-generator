package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Position;

public class PositionSqlProvider {

    public String insertSelective(Position record) {
        BEGIN();
        INSERT_INTO("position");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedate() != null) {
            VALUES("createDate", "#{createdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEnabled() != null) {
            VALUES("enabled", "#{enabled,jdbcType=BIT}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Position record) {
        BEGIN();
        UPDATE("position");
        
        if (record.getName() != null) {
            SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedate() != null) {
            SET("createDate = #{createdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEnabled() != null) {
            SET("enabled = #{enabled,jdbcType=BIT}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}