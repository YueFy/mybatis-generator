package com.test.generator.dao;

import com.test.generator.entity.Employeetrain;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface EmployeetrainMapper {
    @Delete({
        "delete from employeetrain",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into employeetrain (id, eid, ",
        "trainDate, trainContent, ",
        "remark)",
        "values (#{id,jdbcType=INTEGER}, #{eid,jdbcType=INTEGER}, ",
        "#{traindate,jdbcType=DATE}, #{traincontent,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(Employeetrain record);

    @InsertProvider(type=EmployeetrainSqlProvider.class, method="insertSelective")
    int insertSelective(Employeetrain record);

    @Select({
        "select",
        "id, eid, trainDate, trainContent, remark",
        "from employeetrain",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="eid", property="eid", jdbcType=JdbcType.INTEGER),
        @Result(column="trainDate", property="traindate", jdbcType=JdbcType.DATE),
        @Result(column="trainContent", property="traincontent", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    Employeetrain selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EmployeetrainSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Employeetrain record);

    @Update({
        "update employeetrain",
        "set eid = #{eid,jdbcType=INTEGER},",
          "trainDate = #{traindate,jdbcType=DATE},",
          "trainContent = #{traincontent,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Employeetrain record);
}