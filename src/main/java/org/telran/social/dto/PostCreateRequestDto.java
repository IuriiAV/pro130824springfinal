package org.telran.social.dto;

import org.telran.social.emuns.PostStatus;

public record PostCreateRequestDto(String content,
                                   String postStatus,
                                   Long userId) {
}
