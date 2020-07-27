package com.test.generator.dao;

import com.test.generator.entity.MailSendLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface MailSendLogMapper {
    @Insert({
        "insert into mail_send_log (msgId, empId, ",
        "`status`, routeKey, ",
        "exchange, `count`, ",
        "tryTime, createTime, ",
        "updateTime)",
        "values (#{msgid,jdbcType=VARCHAR}, #{empid,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{routekey,jdbcType=VARCHAR}, ",
        "#{exchange,jdbcType=VARCHAR}, #{count,jdbcType=INTEGER}, ",
        "#{trytime,jdbcType=TIMESTAMP}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{updatetime,jdbcType=TIMESTAMP})"
    })
    int insert(MailSendLog record);

    @InsertProvider(type=MailSendLogSqlProvider.class, method="insertSelective")
    int insertSelective(MailSendLog record);
}