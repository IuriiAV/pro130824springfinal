package org.telran.social.service;

public interface Converter<Dto, Entity> {

    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    //Entity createEntity(CreateDto dto);
}
