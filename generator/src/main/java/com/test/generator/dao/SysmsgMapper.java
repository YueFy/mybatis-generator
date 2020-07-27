package com.test.generator.dao;

import com.test.generator.entity.Sysmsg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SysmsgMapper {
    @Delete({
        "delete from sysmsg",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sysmsg (id, mid, ",
        "`type`, hrid, `state`)",
        "values (#{id,jdbcType=INTEGER}, #{mid,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER}, #{hrid,jdbcType=INTEGER}, #{state,jdbcType=INTEGER})"
    })
    int insert(Sysmsg record);

    @InsertProvider(type=SysmsgSqlProvider.class, method="insertSelective")
    int insertSelective(Sysmsg record);

    @Select({
        "select",
        "id, mid, `type`, hrid, `state`",
        "from sysmsg",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mid", property="mid", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="hrid", property="hrid", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER)
    })
    Sysmsg selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysmsgSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sysmsg record);

    @Update({
        "update sysmsg",
        "set mid = #{mid,jdbcType=INTEGER},",
          "`type` = #{type,jdbcType=INTEGER},",
          "hrid = #{hrid,jdbcType=INTEGER},",
          "`state` = #{state,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Sysmsg record);
}