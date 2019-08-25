package com.example.newsapp.model.mapper;

import com.example.cache.dao.article.Article;
import com.example.newsapp.model.ArticleEntity;

public class ArticlesMapper implements MapperImplementation<ArticleEntity, Article> {

    @Override
    public ArticleEntity modelToEntity(Article model) {
        return new ArticleEntity(model.getmId(), model.getmName(), model.getmAuthor(),
                model.getmTitle(), model.getmDescription(), model.getmUrl(), model.getmImage(),
                model.getmDate(), model.getmContent());
    }
}
