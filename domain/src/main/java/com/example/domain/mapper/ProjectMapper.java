package com.example.domain.mapper;

import com.example.cache.dao.article.Article;
import com.example.domain.entity.ArticleEntity;
import com.example.remote.models.Articles;

import java.util.List;

public class ProjectMapper implements EntityMapper<ArticleEntity, Article> {

    @Override
    public ArticleEntity modelToEntity(Article model) {
        return new ArticleEntity(model.getmId(), model.getmName(), model.getmAuthor(),
                model.getmTitle(), model.getmDescription(), model.getmUrl(),
                model.getmImage(), model.getmDate(), model.getmContent());
    }

    @Override
    public Article entityToModel(ArticleEntity model) {
        return new Article(model.getmId(), model.getmName(), model.getmAuthor(),
                model.getmTitle(), model.getmDescription(), model.getmUrl(), model.getmImage(),
                model.getmDate(), model.getmContent());
    }
}
