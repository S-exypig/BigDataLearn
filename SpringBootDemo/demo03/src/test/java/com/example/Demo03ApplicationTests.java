package com.example;

import com.example.dao.ArticleMapper;
import com.example.dao.CommentMapper;
import com.example.pojo.Article;
import com.example.pojo.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class Demo03ApplicationTests {

    @Autowired
    CommentMapper commentMapper;

    @Test
    public void selectComment(){
        System.out.println(commentMapper.selectComment(1));
    }
    @Test
    public void insertComment(){
        System.out.println(commentMapper
                        .insertComment("666,nb", "wfy", 1));
    }

    @Test
    public void updateComment(){
        System.out.println(commentMapper.updateComment("一般般，我不喜欢", 6));
    }

    @Test
    public void updateComment2(){
        Comment comment = new Comment();
        comment.setContent("nb,666");
        comment.setId(7);
        System.out.println(commentMapper.updateComment2(comment));
    }

    @Test
    public void deleteComment(){
        System.out.println(commentMapper.deleteComment(6));
    }

    @Autowired
    DataSource ds;

    @Test
    public void printDs(){
        System.out.println(ds);
    }

    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void selectArticle(){
        Article article = articleMapper.selectArticle(1);
        System.out.println(article);
    }
}
