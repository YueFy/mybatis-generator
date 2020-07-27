package com.test.generator.dao;

import com.test.generator.entity.Position;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PositionMapper {
    @Delete({
        "delete from position",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into position (id, `name`, ",
        "createDate, enabled)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{createdate,jdbcType=TIMESTAMP}, #{enabled,jdbcType=BIT})"
    })
    int insert(Position record);

    @InsertProvider(type=PositionSqlProvider.class, method="insertSelective")
    int insertSelective(Position record);

    @Select({
        "select",
        "id, `name`, createDate, enabled",
        "from position",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="createDate", property="createdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT)
    })
    Position selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PositionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Position record);

    @Update({
        "update position",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "createDate = #{createdate,jdbcType=TIMESTAMP},",
          "enabled = #{enabled,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Position record);
}