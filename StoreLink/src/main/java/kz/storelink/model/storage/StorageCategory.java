package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "storage_category",
        uniqueConstraints = {
                @UniqueConstraint(name = "storage_category_name_unique", columnNames = "storage_category_name")
        }
)
@Data
@NoArgsConstructor
public class StorageCategory implements Serializable {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_category_id;

    @Column(
            name = "storage_category_name",
            nullable = false,
            unique = true,
            length = 32,
            columnDefinition = "TEXT"
    )
    private String storage_category_name;

    @Column(
            name = "storage_category_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String storage_category_description;

    @Column(
            name = "storage_category_image",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String storage_category_image;

    // --- RELATIONS --- //

    // Bidirectional Relations between "StorageCategory and Storage" is @OneToMany annotation linked through FK (Foreign Key)
    // One storage category has many storages
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "storage_id")
    private List<Storage> storages = new ArrayList<>();

}
