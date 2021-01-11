package kz.storelink.model.user;

import kz.storelink.model.item.Item;
import kz.storelink.model.storage.Storage;
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

    // Relation with Item (Many to Many, so Join columns by new table User_Item)
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "User_Item",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "item_id") }
    )
    private Set<Item> item = new HashSet<>();

    // Relation with Storage (Many to Many, so Join columns by new table User_Storage)
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "User_Storage",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "storage_id") }
    )
    private Set<Storage> storage = new HashSet<>();


    private Comment comment;
    @ManyToOne
    public Comment getComment() {
        return comment;
    }
    public void setComment(Comment comment) {
        this.comment = comment;
    }

}
