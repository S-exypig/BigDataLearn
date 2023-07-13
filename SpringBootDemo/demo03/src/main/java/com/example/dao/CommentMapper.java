package com.example.dao;

import com.example.pojo.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select * from t_comment where id=#{id}")
    Comment selectComment(@Param("id") Integer id);

    @Insert("insert into springbootdata.t_comment(content, author, a_id) "+
    "values (#{content},#{author},#{aId})")
    int insertComment( //返回值为int，表示插入数据的条数
            @Param("content") String content,
            @Param("author") String author,
            @Param("aId") Integer aId
    );

    @Update("update springbootdata.t_comment set content=#{c} where id=#{id}")
    int updateComment(@Param("c") String content,@Param("id") Integer id);

    @Update("update t_comment set content=#{content} where id=#{id}")
    int updateComment2(Comment comment);

    @Delete("delete from springbootdata.t_comment where id=#{id}")
    int deleteComment(@Param("id") Integer id);
}
