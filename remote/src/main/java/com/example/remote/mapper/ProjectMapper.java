package com.example.remote.mapper;

import com.example.cache.dao.article.Article;
import com.example.remote.models.Articles;

public class ProjectMapper implements ModelMapper<Articles, Article> {

    @Override
    public Article modelConverter(Articles model) {
        return new Article(model.mSource.mId, model.mSource.mName, model.mAuthor, model.mTitle, model.mDescription, model.mUrl,
                model.mUrlToImage, model.mPublishedAt, model.mContent);
    }
}
