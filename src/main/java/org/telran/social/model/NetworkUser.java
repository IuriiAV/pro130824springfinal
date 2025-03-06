package org.telran.social.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class NetworkUser {

    private Long id;

    private String name;

    private String surname;

    private String login;

    private String password;

    public NetworkUser() {
        //
    }
}
