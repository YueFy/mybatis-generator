package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Oplog;

public class OplogSqlProvider {

    public String insertSelective(Oplog record) {
        BEGIN();
        INSERT_INTO("oplog");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getAdddate() != null) {
            VALUES("addDate", "#{adddate,jdbcType=DATE}");
        }
        
        if (record.getOperate() != null) {
            VALUES("operate", "#{operate,jdbcType=VARCHAR}");
        }
        
        if (record.getHrid() != null) {
            VALUES("hrid", "#{hrid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Oplog record) {
        BEGIN();
        UPDATE("oplog");
        
        if (record.getAdddate() != null) {
            SET("addDate = #{adddate,jdbcType=DATE}");
        }
        
        if (record.getOperate() != null) {
            SET("operate = #{operate,jdbcType=VARCHAR}");
        }
        
        if (record.getHrid() != null) {
            SET("hrid = #{hrid,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}