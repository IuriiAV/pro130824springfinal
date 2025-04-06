package org.telran.mth.mailService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String email;

    private String name;

    private List<Email> emailList;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
        this.emailList = new ArrayList<>();
    }
}
