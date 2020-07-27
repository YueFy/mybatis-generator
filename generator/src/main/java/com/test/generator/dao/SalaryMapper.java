package com.test.generator.dao;

import com.test.generator.entity.Salary;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SalaryMapper {
    @Delete({
        "delete from salary",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into salary (id, basicSalary, ",
        "bonus, lunchSalary, ",
        "trafficSalary, allSalary, ",
        "pensionBase, pensionPer, ",
        "createDate, medicalBase, ",
        "medicalPer, accumulationFundBase, ",
        "accumulationFundPer, `name`)",
        "values (#{id,jdbcType=INTEGER}, #{basicsalary,jdbcType=INTEGER}, ",
        "#{bonus,jdbcType=INTEGER}, #{lunchsalary,jdbcType=INTEGER}, ",
        "#{trafficsalary,jdbcType=INTEGER}, #{allsalary,jdbcType=INTEGER}, ",
        "#{pensionbase,jdbcType=INTEGER}, #{pensionper,jdbcType=REAL}, ",
        "#{createdate,jdbcType=TIMESTAMP}, #{medicalbase,jdbcType=INTEGER}, ",
        "#{medicalper,jdbcType=REAL}, #{accumulationfundbase,jdbcType=INTEGER}, ",
        "#{accumulationfundper,jdbcType=REAL}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Salary record);

    @InsertProvider(type=SalarySqlProvider.class, method="insertSelective")
    int insertSelective(Salary record);

    @Select({
        "select",
        "id, basicSalary, bonus, lunchSalary, trafficSalary, allSalary, pensionBase, ",
        "pensionPer, createDate, medicalBase, medicalPer, accumulationFundBase, accumulationFundPer, ",
        "`name`",
        "from salary",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="basicSalary", property="basicsalary", jdbcType=JdbcType.INTEGER),
        @Result(column="bonus", property="bonus", jdbcType=JdbcType.INTEGER),
        @Result(column="lunchSalary", property="lunchsalary", jdbcType=JdbcType.INTEGER),
        @Result(column="trafficSalary", property="trafficsalary", jdbcType=JdbcType.INTEGER),
        @Result(column="allSalary", property="allsalary", jdbcType=JdbcType.INTEGER),
        @Result(column="pensionBase", property="pensionbase", jdbcType=JdbcType.INTEGER),
        @Result(column="pensionPer", property="pensionper", jdbcType=JdbcType.REAL),
        @Result(column="createDate", property="createdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="medicalBase", property="medicalbase", jdbcType=JdbcType.INTEGER),
        @Result(column="medicalPer", property="medicalper", jdbcType=JdbcType.REAL),
        @Result(column="accumulationFundBase", property="accumulationfundbase", jdbcType=JdbcType.INTEGER),
        @Result(column="accumulationFundPer", property="accumulationfundper", jdbcType=JdbcType.REAL),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Salary selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SalarySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Salary record);

    @Update({
        "update salary",
        "set basicSalary = #{basicsalary,jdbcType=INTEGER},",
          "bonus = #{bonus,jdbcType=INTEGER},",
          "lunchSalary = #{lunchsalary,jdbcType=INTEGER},",
          "trafficSalary = #{trafficsalary,jdbcType=INTEGER},",
          "allSalary = #{allsalary,jdbcType=INTEGER},",
          "pensionBase = #{pensionbase,jdbcType=INTEGER},",
          "pensionPer = #{pensionper,jdbcType=REAL},",
          "createDate = #{createdate,jdbcType=TIMESTAMP},",
          "medicalBase = #{medicalbase,jdbcType=INTEGER},",
          "medicalPer = #{medicalper,jdbcType=REAL},",
          "accumulationFundBase = #{accumulationfundbase,jdbcType=INTEGER},",
          "accumulationFundPer = #{accumulationfundper,jdbcType=REAL},",
          "`name` = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Salary record);
}