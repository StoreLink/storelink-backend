package kz.storelink.model;

import kz.storelink.model.storage.Storage;
import kz.storelink.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_storage")
@Data
@NoArgsConstructor
public class UserStorage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_storage_id;

    // Join two Primary Keys into table User_Storage
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
