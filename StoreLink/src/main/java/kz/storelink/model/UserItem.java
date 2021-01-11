package kz.storelink.model;

import kz.storelink.model.item.Item;
import kz.storelink.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_item")
@Data
@NoArgsConstructor
public class UserItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_item_id;

    // Join two Primary Keys into table User and Item
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}