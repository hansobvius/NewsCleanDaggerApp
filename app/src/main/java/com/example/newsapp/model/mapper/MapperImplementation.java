package com.example.newsapp.model.mapper;

public interface MapperImplementation<E, M> {

    E modelToEntity(M model);
}
