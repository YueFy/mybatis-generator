package com.test.generator.dao;

import com.test.generator.entity.HrRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface HrRoleMapper {
    @Delete({
        "delete from hr_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hr_role (id, hrid, ",
        "rid)",
        "values (#{id,jdbcType=INTEGER}, #{hrid,jdbcType=INTEGER}, ",
        "#{rid,jdbcType=INTEGER})"
    })
    int insert(HrRole record);

    @InsertProvider(type=HrRoleSqlProvider.class, method="insertSelective")
    int insertSelective(HrRole record);

    @Select({
        "select",
        "id, hrid, rid",
        "from hr_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="hrid", property="hrid", jdbcType=JdbcType.INTEGER),
        @Result(column="rid", property="rid", jdbcType=JdbcType.INTEGER)
    })
    HrRole selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HrRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HrRole record);

    @Update({
        "update hr_role",
        "set hrid = #{hrid,jdbcType=INTEGER},",
          "rid = #{rid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HrRole record);
}