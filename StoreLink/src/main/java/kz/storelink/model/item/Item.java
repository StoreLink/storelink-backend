package kz.storelink.model.item;

import kz.storelink.model.StorageItem;
import kz.storelink.model.UserItem;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    @NotNull
    @NotEmpty
    private String item_name;
    private String item_description;
    private Long item_count;
    private Double item_size;

    // Relations between Item and category is Many to One annotation linked through FK
    // Many items can take the same category
    @ManyToOne
    @JoinColumn(name = "item_category_id")
    private ItemCategory itemCategory;

    // Extra column Relation Many to Many Item-Storage
    @OneToMany(mappedBy = "item_id")
    private final Set<StorageItem> storageItem = new HashSet<StorageItem>();
    @OneToMany(mappedBy = "item_id")
    private final Set<UserItem> userItem = new HashSet<UserItem>();

}
