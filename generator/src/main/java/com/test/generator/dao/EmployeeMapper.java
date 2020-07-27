package com.test.generator.dao;

import com.test.generator.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface EmployeeMapper {
    @Delete({
        "delete from employee",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into employee (id, `name`, ",
        "gender, birthday, idCard, ",
        "wedlock, nationId, ",
        "nativePlace, politicId, ",
        "email, phone, address, ",
        "departmentId, jobLevelId, ",
        "posId, engageForm, ",
        "tiptopDegree, specialty, ",
        "school, beginDate, ",
        "workState, workID, contractTerm, ",
        "conversionTime, notWorkDate, ",
        "beginContract, endContract, ",
        "workAge)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{gender,jdbcType=CHAR}, #{birthday,jdbcType=DATE}, #{idcard,jdbcType=CHAR}, ",
        "#{wedlock,jdbcType=CHAR}, #{nationid,jdbcType=INTEGER}, ",
        "#{nativeplace,jdbcType=VARCHAR}, #{politicid,jdbcType=INTEGER}, ",
        "#{email,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{departmentid,jdbcType=INTEGER}, #{joblevelid,jdbcType=INTEGER}, ",
        "#{posid,jdbcType=INTEGER}, #{engageform,jdbcType=VARCHAR}, ",
        "#{tiptopdegree,jdbcType=CHAR}, #{specialty,jdbcType=VARCHAR}, ",
        "#{school,jdbcType=VARCHAR}, #{begindate,jdbcType=DATE}, ",
        "#{workstate,jdbcType=CHAR}, #{workid,jdbcType=CHAR}, #{contractterm,jdbcType=DOUBLE}, ",
        "#{conversiontime,jdbcType=DATE}, #{notworkdate,jdbcType=DATE}, ",
        "#{begincontract,jdbcType=DATE}, #{endcontract,jdbcType=DATE}, ",
        "#{workage,jdbcType=INTEGER})"
    })
    int insert(Employee record);

    @InsertProvider(type=EmployeeSqlProvider.class, method="insertSelective")
    int insertSelective(Employee record);

    @Select({
        "select",
        "id, `name`, gender, birthday, idCard, wedlock, nationId, nativePlace, politicId, ",
        "email, phone, address, departmentId, jobLevelId, posId, engageForm, tiptopDegree, ",
        "specialty, school, beginDate, workState, workID, contractTerm, conversionTime, ",
        "notWorkDate, beginContract, endContract, workAge",
        "from employee",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.CHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="idCard", property="idcard", jdbcType=JdbcType.CHAR),
        @Result(column="wedlock", property="wedlock", jdbcType=JdbcType.CHAR),
        @Result(column="nationId", property="nationid", jdbcType=JdbcType.INTEGER),
        @Result(column="nativePlace", property="nativeplace", jdbcType=JdbcType.VARCHAR),
        @Result(column="politicId", property="politicid", jdbcType=JdbcType.INTEGER),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="departmentId", property="departmentid", jdbcType=JdbcType.INTEGER),
        @Result(column="jobLevelId", property="joblevelid", jdbcType=JdbcType.INTEGER),
        @Result(column="posId", property="posid", jdbcType=JdbcType.INTEGER),
        @Result(column="engageForm", property="engageform", jdbcType=JdbcType.VARCHAR),
        @Result(column="tiptopDegree", property="tiptopdegree", jdbcType=JdbcType.CHAR),
        @Result(column="specialty", property="specialty", jdbcType=JdbcType.VARCHAR),
        @Result(column="school", property="school", jdbcType=JdbcType.VARCHAR),
        @Result(column="beginDate", property="begindate", jdbcType=JdbcType.DATE),
        @Result(column="workState", property="workstate", jdbcType=JdbcType.CHAR),
        @Result(column="workID", property="workid", jdbcType=JdbcType.CHAR),
        @Result(column="contractTerm", property="contractterm", jdbcType=JdbcType.DOUBLE),
        @Result(column="conversionTime", property="conversiontime", jdbcType=JdbcType.DATE),
        @Result(column="notWorkDate", property="notworkdate", jdbcType=JdbcType.DATE),
        @Result(column="beginContract", property="begincontract", jdbcType=JdbcType.DATE),
        @Result(column="endContract", property="endcontract", jdbcType=JdbcType.DATE),
        @Result(column="workAge", property="workage", jdbcType=JdbcType.INTEGER)
    })
    Employee selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EmployeeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Employee record);

    @Update({
        "update employee",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=CHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "idCard = #{idcard,jdbcType=CHAR},",
          "wedlock = #{wedlock,jdbcType=CHAR},",
          "nationId = #{nationid,jdbcType=INTEGER},",
          "nativePlace = #{nativeplace,jdbcType=VARCHAR},",
          "politicId = #{politicid,jdbcType=INTEGER},",
          "email = #{email,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "departmentId = #{departmentid,jdbcType=INTEGER},",
          "jobLevelId = #{joblevelid,jdbcType=INTEGER},",
          "posId = #{posid,jdbcType=INTEGER},",
          "engageForm = #{engageform,jdbcType=VARCHAR},",
          "tiptopDegree = #{tiptopdegree,jdbcType=CHAR},",
          "specialty = #{specialty,jdbcType=VARCHAR},",
          "school = #{school,jdbcType=VARCHAR},",
          "beginDate = #{begindate,jdbcType=DATE},",
          "workState = #{workstate,jdbcType=CHAR},",
          "workID = #{workid,jdbcType=CHAR},",
          "contractTerm = #{contractterm,jdbcType=DOUBLE},",
          "conversionTime = #{conversiontime,jdbcType=DATE},",
          "notWorkDate = #{notworkdate,jdbcType=DATE},",
          "beginContract = #{begincontract,jdbcType=DATE},",
          "endContract = #{endcontract,jdbcType=DATE},",
          "workAge = #{workage,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Employee record);
}