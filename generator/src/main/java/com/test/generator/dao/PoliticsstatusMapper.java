package com.test.generator.dao;

import com.test.generator.entity.Politicsstatus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PoliticsstatusMapper {
    @Delete({
        "delete from politicsstatus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into politicsstatus (id, `name`)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Politicsstatus record);

    @InsertProvider(type=PoliticsstatusSqlProvider.class, method="insertSelective")
    int insertSelective(Politicsstatus record);

    @Select({
        "select",
        "id, `name`",
        "from politicsstatus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Politicsstatus selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PoliticsstatusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Politicsstatus record);

    @Update({
        "update politicsstatus",
        "set `name` = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Politicsstatus record);
}