package com.example.dao;

import com.example.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
//    只能查询单个id
    Article selectArticle(Integer id);
//    通过foreach查询多个id
    List<Article> selectArticles(Integer... ids);
}
