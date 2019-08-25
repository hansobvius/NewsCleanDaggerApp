package com.example.remote.mapper;

public interface ModelMapper<T, E> {

    E modelConverter(T model);

}
