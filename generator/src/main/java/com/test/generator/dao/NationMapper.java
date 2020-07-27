package com.test.generator.dao;

import com.test.generator.entity.Nation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface NationMapper {
    @Delete({
        "delete from nation",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into nation (id, `name`)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Nation record);

    @InsertProvider(type=NationSqlProvider.class, method="insertSelective")
    int insertSelective(Nation record);

    @Select({
        "select",
        "id, `name`",
        "from nation",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Nation selectByPrimaryKey(Integer id);

    @UpdateProvider(type=NationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Nation record);

    @Update({
        "update nation",
        "set `name` = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Nation record);
}