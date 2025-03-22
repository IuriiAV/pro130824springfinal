package org.telran.social.service;

import org.springframework.stereotype.Component;
import org.telran.social.dto.NetworkUserResponseDto;
import org.telran.social.entity.NetworkUser;

@Component
public class NetworkUserConverter implements Converter<NetworkUserResponseDto, NetworkUser> {

    @Override
    public NetworkUserResponseDto toDto(NetworkUser user) {
        return NetworkUserResponseDto.builder()
                .name(user.getName())
                .id(user.getId())
                .surname(user.getSurname())
                //.posts(user.getPost())
                .build();
    }

    @Override
    public NetworkUser toEntity(NetworkUserResponseDto networkUserResponseDto) {
        return null;
    }
}
