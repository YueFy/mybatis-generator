package com.test.generator.dao;

import com.test.generator.entity.Oplog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OplogMapper {
    @Delete({
        "delete from oplog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into oplog (id, addDate, ",
        "operate, hrid)",
        "values (#{id,jdbcType=INTEGER}, #{adddate,jdbcType=DATE}, ",
        "#{operate,jdbcType=VARCHAR}, #{hrid,jdbcType=INTEGER})"
    })
    int insert(Oplog record);

    @InsertProvider(type=OplogSqlProvider.class, method="insertSelective")
    int insertSelective(Oplog record);

    @Select({
        "select",
        "id, addDate, operate, hrid",
        "from oplog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="addDate", property="adddate", jdbcType=JdbcType.DATE),
        @Result(column="operate", property="operate", jdbcType=JdbcType.VARCHAR),
        @Result(column="hrid", property="hrid", jdbcType=JdbcType.INTEGER)
    })
    Oplog selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OplogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Oplog record);

    @Update({
        "update oplog",
        "set addDate = #{adddate,jdbcType=DATE},",
          "operate = #{operate,jdbcType=VARCHAR},",
          "hrid = #{hrid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Oplog record);
}