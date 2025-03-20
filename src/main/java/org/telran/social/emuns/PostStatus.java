package org.telran.social.emuns;

public enum PostStatus {
    DRAFT,
    PUBLISHED;

    public static PostStatus getValue(String value) {
        for (PostStatus status : values()) {
            if(status.name().equals(value)) {
                return status;
            }
        }
        return DRAFT;
    }
}
