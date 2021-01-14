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
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String username;
    private String phone_number;
    private String nin;
    private String password;


    // Relations between User and Role is @ManytoOne annotation linked through FK (Foreign Key)
    // Many users can take the same role
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    // Extra column Relation Many to Many Storage-User(Comment), User and Storage, User and Item
    // We need to get data. Type of Data is LIST
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(mappedBy = "comment_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comment;
    @OneToMany(mappedBy = "user_storage_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserStorage> userStorage;
    @OneToMany(mappedBy = "user_item_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserItem> userItem;

}
