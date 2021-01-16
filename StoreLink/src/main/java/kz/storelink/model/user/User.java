package kz.storelink.model.user;

import kz.storelink.model.Comment;
import kz.storelink.model.item.Item;
import kz.storelink.model.storage.Storage;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements Serializable {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @NotNull
    @NotEmpty
    @Size(max = 32)
    @Column(unique = true)
    private String username,
            phone_number,
            password;

    // --- RELATIONS --- //

    // Relations between User and UserDetail is @OneToOne
    // One user has one detail
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    // mappedBy is look for a field named user in the UserDetails entity
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private UserDetails userDetails;

    // Relations between "User and Role" is @ManyToOne annotation linked through FK (Foreign Key)
    // Many users can take the same role
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false, updatable = true)
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
