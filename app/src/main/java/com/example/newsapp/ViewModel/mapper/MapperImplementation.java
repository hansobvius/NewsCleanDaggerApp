package com.example.newsapp.ViewModel.mapper;

import java.util.List;

public interface MapperImplementation<M, E> {

    M entityToModel(E entity);
}
