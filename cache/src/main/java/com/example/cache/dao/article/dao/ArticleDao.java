package com.example.cache.dao.article.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.cache.dao.article.Article;

import java.util.List;

@Dao
public interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertArticle(List<Article> article);

    @Query("SELECT * from article_table")
    List<Article> getAllArticles();
}
