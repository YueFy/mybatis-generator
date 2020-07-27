package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.test.generator.entity.Msgcontent;

public class MsgcontentSqlProvider {

    public String insertSelective(Msgcontent record) {
        BEGIN();
        INSERT_INTO("msgcontent");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getMessage() != null) {
            VALUES("message", "#{message,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedate() != null) {
            VALUES("createDate", "#{createdate,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Msgcontent record) {
        BEGIN();
        UPDATE("msgcontent");
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getMessage() != null) {
            SET("message = #{message,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedate() != null) {
            SET("createDate = #{createdate,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}