package com.example.dao;

import com.example.pojo.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select * from springbootdata.t_comment where id in (#{id1},#{id2},#{id3})")
    List<Comment> findById(@Param("id1") Integer id1,@Param("id2") Integer id2,@Param("id3") Integer id3);

    @Insert("insert into springbootdata.t_comment(content, author, a_id) "+
    "values (#{content},#{author},#{aId})")
    int insertComment( //返回值为int，表示插入数据的条数
            @Param("content") String content,
            @Param("author") String author,
            @Param("aId") Integer aId
    );

    @Update("update springbootdata.t_comment set content=#{c} where id=#{id}")
    int updateComment(@Param("c") String content,@Param("id") Integer id);

    @Delete("delete from springbootdata.t_comment where id=#{id}")
    int deleteComment(@Param("id") Integer id);
}
