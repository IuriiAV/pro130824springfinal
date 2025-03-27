package org.telran.social.service;

public interface Converter<RequestDto, ResponseDto, Entity> {

    ResponseDto toDto(Entity entity);

    Entity toEntity(RequestDto dto);
}
