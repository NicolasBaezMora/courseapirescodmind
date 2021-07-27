package com.orderapi.orderapi.converters;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E, D> {

    public abstract D fromEntity(E entity);

    public abstract E fromDTO(D dto);

    public List<D> fromEntity(List<E> listEntities) {
        return listEntities.stream().map(e -> fromEntity(e)).collect(Collectors.toList());
    }

    public List<E> fromDTO(List<D> listDto) {
        return listDto.stream().map(D -> fromDTO(D)).collect(Collectors.toList());
    }


}
