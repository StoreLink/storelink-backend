package kz.storelink.model.user;

import kz.storelink.model.Comment;
import kz.storelink.model.UserItem;
import kz.storelink.model.UserStorage;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    //User Attributes
    @NotNull
    @NotEmpty
    private String full_name;
    private String phone_number;
    private String nin;
    private String email;
    private String password;
    private String user_image;
    private String payment_card;

    // Relations between User and Role is Many to One annotation linked through FK
    // Many users can take the same role
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    // Extra column Relation Many to Many Storage-User(Comment), User and Storage, User and Item
    @OneToMany(mappedBy = "user_id")
    private final Set<Comment> comment = new HashSet<Comment>();
    @OneToMany(mappedBy = "user_id")
    private final Set<UserStorage> userStorage = new HashSet<UserStorage>();
    @OneToMany(mappedBy = "user_id")
    private final Set<UserItem> userItem = new HashSet<UserItem>();

}
