package org.telran.social.entity;

import jakarta.persistence.*;
import org.telran.social.emuns.PostStatus;

import java.util.Objects;

@Entity //объекты данно класса будут сохраняться в базу данных и обратно
@Table(name = "posts") // таблица, в которую будут сохраняться
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement and primary_key
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING) //storage enum in DB as String
    private PostStatus postStatus;

    public Post() {
        //
    }

    public Post(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Post post)) return false;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
