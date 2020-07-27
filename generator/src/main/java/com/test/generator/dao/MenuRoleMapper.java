package com.test.generator.dao;

import com.test.generator.entity.MenuRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MenuRoleMapper {
    @Delete({
        "delete from menu_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into menu_role (id, mid, ",
        "rid)",
        "values (#{id,jdbcType=INTEGER}, #{mid,jdbcType=INTEGER}, ",
        "#{rid,jdbcType=INTEGER})"
    })
    int insert(MenuRole record);

    @InsertProvider(type=MenuRoleSqlProvider.class, method="insertSelective")
    int insertSelective(MenuRole record);

    @Select({
        "select",
        "id, mid, rid",
        "from menu_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mid", property="mid", jdbcType=JdbcType.INTEGER),
        @Result(column="rid", property="rid", jdbcType=JdbcType.INTEGER)
    })
    MenuRole selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MenuRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MenuRole record);

    @Update({
        "update menu_role",
        "set mid = #{mid,jdbcType=INTEGER},",
          "rid = #{rid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MenuRole record);
}