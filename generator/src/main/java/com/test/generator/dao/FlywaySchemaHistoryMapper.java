package com.test.generator.dao;

import com.test.generator.entity.FlywaySchemaHistory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FlywaySchemaHistoryMapper {
    @Delete({
        "delete from flyway_schema_history",
        "where installed_rank = #{installedRank,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer installedRank);

    @Insert({
        "insert into flyway_schema_history (installed_rank, version, ",
        "description, `type`, ",
        "script, `checksum`, ",
        "installed_by, installed_on, ",
        "execution_time, success)",
        "values (#{installedRank,jdbcType=INTEGER}, #{version,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{script,jdbcType=VARCHAR}, #{checksum,jdbcType=INTEGER}, ",
        "#{installedBy,jdbcType=VARCHAR}, #{installedOn,jdbcType=TIMESTAMP}, ",
        "#{executionTime,jdbcType=INTEGER}, #{success,jdbcType=BIT})"
    })
    int insert(FlywaySchemaHistory record);

    @InsertProvider(type=FlywaySchemaHistorySqlProvider.class, method="insertSelective")
    int insertSelective(FlywaySchemaHistory record);

    @Select({
        "select",
        "installed_rank, version, description, `type`, script, `checksum`, installed_by, ",
        "installed_on, execution_time, success",
        "from flyway_schema_history",
        "where installed_rank = #{installedRank,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="installed_rank", property="installedRank", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="version", property="version", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="script", property="script", jdbcType=JdbcType.VARCHAR),
        @Result(column="checksum", property="checksum", jdbcType=JdbcType.INTEGER),
        @Result(column="installed_by", property="installedBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="installed_on", property="installedOn", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="execution_time", property="executionTime", jdbcType=JdbcType.INTEGER),
        @Result(column="success", property="success", jdbcType=JdbcType.BIT)
    })
    FlywaySchemaHistory selectByPrimaryKey(Integer installedRank);

    @UpdateProvider(type=FlywaySchemaHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FlywaySchemaHistory record);

    @Update({
        "update flyway_schema_history",
        "set version = #{version,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=VARCHAR},",
          "script = #{script,jdbcType=VARCHAR},",
          "`checksum` = #{checksum,jdbcType=INTEGER},",
          "installed_by = #{installedBy,jdbcType=VARCHAR},",
          "installed_on = #{installedOn,jdbcType=TIMESTAMP},",
          "execution_time = #{executionTime,jdbcType=INTEGER},",
          "success = #{success,jdbcType=BIT}",
        "where installed_rank = #{installedRank,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FlywaySchemaHistory record);
}