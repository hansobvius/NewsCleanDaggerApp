package com.example.domain.mapper;

public interface EntityMapper<E, M> {

    E modelToEntity(M model);
}
