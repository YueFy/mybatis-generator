package com.test.generator.dao;

import com.test.generator.entity.Employeeremove;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface EmployeeremoveMapper {
    @Delete({
        "delete from employeeremove",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into employeeremove (id, eid, ",
        "afterDepId, afterJobId, ",
        "removeDate, reason, ",
        "remark)",
        "values (#{id,jdbcType=INTEGER}, #{eid,jdbcType=INTEGER}, ",
        "#{afterdepid,jdbcType=INTEGER}, #{afterjobid,jdbcType=INTEGER}, ",
        "#{removedate,jdbcType=DATE}, #{reason,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(Employeeremove record);

    @InsertProvider(type=EmployeeremoveSqlProvider.class, method="insertSelective")
    int insertSelective(Employeeremove record);

    @Select({
        "select",
        "id, eid, afterDepId, afterJobId, removeDate, reason, remark",
        "from employeeremove",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eid", property="eid", jdbcType=JdbcType.INTEGER),
        @Result(column="afterDepId", property="afterdepid", jdbcType=JdbcType.INTEGER),
        @Result(column="afterJobId", property="afterjobid", jdbcType=JdbcType.INTEGER),
        @Result(column="removeDate", property="removedate", jdbcType=JdbcType.DATE),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    Employeeremove selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EmployeeremoveSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Employeeremove record);

    @Update({
        "update employeeremove",
        "set eid = #{eid,jdbcType=INTEGER},",
          "afterDepId = #{afterdepid,jdbcType=INTEGER},",
          "afterJobId = #{afterjobid,jdbcType=INTEGER},",
          "removeDate = #{removedate,jdbcType=DATE},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Employeeremove record);
}