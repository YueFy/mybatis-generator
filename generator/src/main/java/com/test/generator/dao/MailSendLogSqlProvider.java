package com.test.generator.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.test.generator.entity.MailSendLog;

public class MailSendLogSqlProvider {

    public String insertSelective(MailSendLog record) {
        BEGIN();
        INSERT_INTO("mail_send_log");
        
        if (record.getMsgid() != null) {
            VALUES("msgId", "#{msgid,jdbcType=VARCHAR}");
        }
        
        if (record.getEmpid() != null) {
            VALUES("empId", "#{empid,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            VALUES("`status`", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getRoutekey() != null) {
            VALUES("routeKey", "#{routekey,jdbcType=VARCHAR}");
        }
        
        if (record.getExchange() != null) {
            VALUES("exchange", "#{exchange,jdbcType=VARCHAR}");
        }
        
        if (record.getCount() != null) {
            VALUES("`count`", "#{count,jdbcType=INTEGER}");
        }
        
        if (record.getTrytime() != null) {
            VALUES("tryTime", "#{trytime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreatetime() != null) {
            VALUES("createTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            VALUES("updateTime", "#{updatetime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }
}