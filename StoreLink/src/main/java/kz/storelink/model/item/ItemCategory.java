package kz.storelink.model.item;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "item_category")
@Data
@NoArgsConstructor
public class ItemCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemCategoryId;
    private String itemCategoryName;
    private String itemCategoryDescription;
    private String itemCategoryImage;

    // Bidirectional Relations between "ItemCategory and Item" is @OneToMany annotation linked through FK (Foreign Key)
    // One Item Category has many Item Categories
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Item> items;

}
