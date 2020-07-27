package com.test.generator.dao;

import com.test.generator.entity.Employeeec;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface EmployeeecMapper {
    @Delete({
        "delete from employeeec",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into employeeec (id, eid, ",
        "ecDate, ecReason, ecPoint, ",
        "ecType, remark)",
        "values (#{id,jdbcType=INTEGER}, #{eid,jdbcType=INTEGER}, ",
        "#{ecdate,jdbcType=DATE}, #{ecreason,jdbcType=VARCHAR}, #{ecpoint,jdbcType=INTEGER}, ",
        "#{ectype,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(Employeeec record);

    @InsertProvider(type=EmployeeecSqlProvider.class, method="insertSelective")
    int insertSelective(Employeeec record);

    @Select({
        "select",
        "id, eid, ecDate, ecReason, ecPoint, ecType, remark",
        "from employeeec",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eid", property="eid", jdbcType=JdbcType.INTEGER),
        @Result(column="ecDate", property="ecdate", jdbcType=JdbcType.DATE),
        @Result(column="ecReason", property="ecreason", jdbcType=JdbcType.VARCHAR),
        @Result(column="ecPoint", property="ecpoint", jdbcType=JdbcType.INTEGER),
        @Result(column="ecType", property="ectype", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    Employeeec selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EmployeeecSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Employeeec record);

    @Update({
        "update employeeec",
        "set eid = #{eid,jdbcType=INTEGER},",
          "ecDate = #{ecdate,jdbcType=DATE},",
          "ecReason = #{ecreason,jdbcType=VARCHAR},",
          "ecPoint = #{ecpoint,jdbcType=INTEGER},",
          "ecType = #{ectype,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Employeeec record);
}