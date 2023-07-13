package com.example.dao;

import com.example.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    Article selectArticle(Integer id);
}
