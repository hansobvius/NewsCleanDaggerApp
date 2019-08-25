package com.example.domain.mapper;

import java.util.List;

public interface EntityMapper<E, M> {

    E modelToEntity(M model);
}
