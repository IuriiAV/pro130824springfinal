package org.telran.social.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class NetworkUserResponseDto {

    private Long id;

    private String name;

    private String surname;

    public NetworkUserResponseDto() {
        //
    }
}
