package org.telran.social.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.telran.social.entity.Post;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class NetworkUserResponseDto {

    private Long id;

    private String name;

    private String surname;

    private List<Post> posts;

    public NetworkUserResponseDto() {
        //
    }
}
