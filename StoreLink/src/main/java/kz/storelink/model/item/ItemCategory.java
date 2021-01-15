package kz.storelink.model.item;

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
@Table(name = "item_category")
@Data
@NoArgsConstructor
public class ItemCategory implements Serializable {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_category_id;

    @NotNull
    @NotEmpty
    @Size(max = 32)
    @Column(unique = true)
    private String item_category_name;

    @NotNull
    @NotEmpty
    @Size(max = 64)
    private String item_category_description;

    @NotNull
    @NotEmpty
    @Size(max = 64)
    private String item_category_image;

    // --- RELATIONS --- //

    // Bidirectional Relations between "ItemCategory and Item" is @OneToMany annotation linked through FK (Foreign Key)
    // One Item Category has many Item Categories
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item_id")
    private List<Item> items = new ArrayList<>();

}
