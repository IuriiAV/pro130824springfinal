package org.telran.social.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.userdetails.UserDetails;
import org.telran.social.emuns.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * OneToOne - user(user_id,name) -> posts(post_id,content,user_id(unique))
 * user (1, Alex), posts(1,"Hello",1)
 * <p>
 * SELECT user.*, posts.*
 * FROM user
 * LEFT JOIN posts
 * ON posts.user_id = user.user_id
 * <p>
 * <p>
 * OneToMany - user(user_id,name) -> posts(post_id,content,user_id)
 * user (1, Alex), posts(1,"Hello",1), (2,"Hi",1);
 * <p>
 * SELECT user.*, posts.*
 * FROM user
 * LEFT JOIN posts
 * ON posts.user_id = user.user_id
 * <p>
 * ManyToMany
 * customer, shop -> customer(shop1,shop2,shop3)
 * -> shop(customer1, customer2, etc)
 * table link  -> shop2customer(shop_id, customer_id)
 * <p>
 * 1, Max, 1 (save)
 * <p>
 * 1, "Hello" (save)
 * <p>
 * 1,Max
 * <p>
 * 1, "Hi", 1
 */

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@Entity
@Table(name = "network_user")
public class NetworkUser {

    @Id // указывает что это поле первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // задает автогенерацию значения поля
    private Long id;

    private String name;

    private String surname;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    //EAGER - все выбирается сразу (default)
    //LAZY - все выбирается при запросе к данным

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    //@JoinColumn(name = "network_user_id")
    private List<Post> post = new ArrayList<>();

    public NetworkUser() {
        //
    }
}
