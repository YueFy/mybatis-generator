package com.test.generator.dao;

import com.test.generator.entity.Appraise;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AppraiseMapper {
    @Delete({
        "delete from appraise",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into appraise (id, eid, ",
        "appDate, appResult, ",
        "appContent, remark)",
        "values (#{id,jdbcType=INTEGER}, #{eid,jdbcType=INTEGER}, ",
        "#{appdate,jdbcType=DATE}, #{appresult,jdbcType=VARCHAR}, ",
        "#{appcontent,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(Appraise record);

    @InsertProvider(type=AppraiseSqlProvider.class, method="insertSelective")
    int insertSelective(Appraise record);

    @Select({
        "select",
        "id, eid, appDate, appResult, appContent, remark",
        "from appraise",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eid", property="eid", jdbcType=JdbcType.INTEGER),
        @Result(column="appDate", property="appdate", jdbcType=JdbcType.DATE),
        @Result(column="appResult", property="appresult", jdbcType=JdbcType.VARCHAR),
        @Result(column="appContent", property="appcontent", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    Appraise selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AppraiseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Appraise record);

    @Update({
        "update appraise",
        "set eid = #{eid,jdbcType=INTEGER},",
          "appDate = #{appdate,jdbcType=DATE},",
          "appResult = #{appresult,jdbcType=VARCHAR},",
          "appContent = #{appcontent,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Appraise record);
}