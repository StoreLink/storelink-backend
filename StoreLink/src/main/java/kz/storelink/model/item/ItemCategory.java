package kz.storelink.model.item;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "item_category",
        uniqueConstraints = {
                @UniqueConstraint(name = "item_category_name_unique", columnNames = "item_category_name")
        }
)
@Data
@NoArgsConstructor
public class ItemCategory implements Serializable {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_category_id;

    @Column(
            name = "item_category_name",
            nullable = false,
            unique = true,
            length = 32,
            columnDefinition = "TEXT"
    )
    private String item_category_name;

    @Column(
            name = "item_category_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String item_category_description;

    @Column(
            name = "item_category_image",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String item_category_image;

    // --- RELATIONS --- //

    // Bidirectional Relations between "ItemCategory and Item" is @OneToMany annotation linked through FK (Foreign Key)
    // One Item Category has many Item Categories
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item_id")
    private List<Item> items = new ArrayList<>();

}
