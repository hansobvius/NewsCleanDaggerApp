package com.example.newsapp.model.mapper;

import com.example.newsapp.model.Article;

public class ArticlesMapper implements MapperImplementation<Article, Article> {

    @Override
    public Article modelToEntity(Article model) {
        return new Article(model.getmId(), model.getmName(), model.getmAuthor(),
                model.getmTitle(), model.getmDescription(), model.getmUrl(), model.getmImage(),
                model.getmDate(), model.getmContent());
    }
}
