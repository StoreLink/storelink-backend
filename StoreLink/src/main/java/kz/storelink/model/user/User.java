package kz.storelink.model.user;

import kz.storelink.model.Comment;
import kz.storelink.model.item.Item;
import kz.storelink.model.storage.Storage;
import kz.storelink.repository.item.ItemRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "username_unique", columnNames = "username"),
                @UniqueConstraint(name = "phone_number_unique", columnNames = "phone_number"),
                @UniqueConstraint(name = "password_unique", columnNames = "password")
        }
)
@Data
@NoArgsConstructor
public class User implements Serializable {

    // --- COLUMNS --- //

    new ItemRepository

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(
            name = "username",
            nullable = false,
            unique = true,
            length = 32,
            columnDefinition = "TEXT"
    )
    private String username;

    @Column(
            name = "phone_number",
            nullable = false,
            unique = true,
            length = 12,
            columnDefinition = "TEXT"
    )
    private String phone_number;

    @Column(
            name = "password",
            nullable = false,
            unique = true,
            length = 32,
            columnDefinition = "TEXT"
    )
    private String password;

    // --- RELATIONS --- //

    // Relations between User and UserDetail is @OneToOne
    // One user has one detail
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    // mappedBy is look for a field named user in the UserDetails entity
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserDetails userDetails;

    // Relations between "User and Role" is @ManyToOne annotation linked through FK (Foreign Key)
    // Many users can take the same role
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    // Bidirectional Relations between "User and Comment", "User and Storage", "User and Item"
    // is @OneToMany annotation linked through FK (Foreign Key)
    // One user has many comments, storages, items
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "comment_id")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "storage_id")
    private List<Storage> storages = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item_id")
    private List<Item> items = new ArrayList<>();

}
