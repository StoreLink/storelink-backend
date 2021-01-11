package kz.storelink.model.user;

import kz.storelink.model.storage.Storage;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    @NotNull
    @NotEmpty
    private String comment_text;
    private Double rate;

    // Relation with User and Storage One to Many
    @OneToMany(mappedBy = "comment")
    private final List<User> user = new ArrayList<User>();
    @OneToMany(mappedBy = "comment")
    private final List<Storage> storage = new ArrayList<Storage>();

}
