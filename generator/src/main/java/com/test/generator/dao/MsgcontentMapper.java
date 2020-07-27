package com.test.generator.dao;

import com.test.generator.entity.Msgcontent;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MsgcontentMapper {
    @Delete({
        "delete from msgcontent",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into msgcontent (id, title, ",
        "message, createDate)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{message,jdbcType=VARCHAR}, #{createdate,jdbcType=TIMESTAMP})"
    })
    int insert(Msgcontent record);

    @InsertProvider(type=MsgcontentSqlProvider.class, method="insertSelective")
    int insertSelective(Msgcontent record);

    @Select({
        "select",
        "id, title, message, createDate",
        "from msgcontent",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="createDate", property="createdate", jdbcType=JdbcType.TIMESTAMP)
    })
    Msgcontent selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MsgcontentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Msgcontent record);

    @Update({
        "update msgcontent",
        "set title = #{title,jdbcType=VARCHAR},",
          "message = #{message,jdbcType=VARCHAR},",
          "createDate = #{createdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Msgcontent record);
}