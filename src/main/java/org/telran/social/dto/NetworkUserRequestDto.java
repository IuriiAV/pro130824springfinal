package org.telran.social.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NetworkUserRequestDto {

    private String name;

    private String surname;

    private String login;

    private String password;
}
