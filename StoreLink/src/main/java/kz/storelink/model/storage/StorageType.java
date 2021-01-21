package kz.storelink.model.storage;

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
@Table(
        name = "storage_type",
        uniqueConstraints = {
                @UniqueConstraint(name = "storage_type_name_unique", columnNames = "storage_type_name")
        }
)
@Data
@NoArgsConstructor
public class StorageType implements Serializable {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_type_id;

    @Column(
            name = "storage_type_name",
            nullable = false,
            unique = true,
            length = 32,
            columnDefinition = "TEXT"
    )
    private String storage_type_name;

    @Column(
            name = "storage_type_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String storage_type_description;

    @Column(
            name = "storage_type_image",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String storage_type_image;

    // --- RELATIONS --- //

    // Bidirectional Relations between "StorageType and Storage" is @OneToMany annotation linked through FK (Foreign Key)
    // One storage type has many storages
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "storage_id")
    private List<Storage> storages = new ArrayList<>();

}
