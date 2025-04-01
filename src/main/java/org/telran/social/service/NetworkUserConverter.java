package org.telran.social.service;

import org.springframework.stereotype.Component;
import org.telran.social.dto.NetworkUserRequestDto;
import org.telran.social.dto.NetworkUserResponseDto;
import org.telran.social.emuns.Role;
import org.telran.social.entity.NetworkUser;

@Component
public class NetworkUserConverter implements
        Converter<NetworkUserRequestDto,
                NetworkUserResponseDto, NetworkUser> {

    @Override
    public NetworkUserResponseDto toDto(NetworkUser user) {
        return NetworkUserResponseDto.builder()
                .name(user.getName())
                .id(user.getId())
                .surname(user.getSurname())
                .build();
    }

    @Override
    public NetworkUser toEntity(NetworkUserRequestDto requestDto) {
        return NetworkUser.builder()
                .name(requestDto.getName())
                .surname(requestDto.getSurname())
                .login(requestDto.getLogin())
                .role(Role.ROLE_USER)
                .password(requestDto.getPassword())
                .build();
    }
}
