package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "parameter",
        uniqueConstraints = {
                @UniqueConstraint(name = "parameter_name_unique", columnNames = "parameter_name")
        }
)
@Data
@NoArgsConstructor
public class Parameter implements Serializable {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parameter_id;

    @Column(
            name = "parameter_name",
            nullable = false,
            unique = true,
            columnDefinition = "TEXT"
    )
    private String parameter_name;

    @Column(
            name = "parameter_image",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String parameter_image;

    // --- RELATIONS --- //

    // Bidirectional Relations between "Parameter and StorageParameter" is @OneToMany annotation linked through FK (Foreign Key)
    // One StorageParameter has many Parameters
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    // Extra column Relation Many to Many Storage-Parameter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "storage_parameter_id")
    private List<StorageParameter> storageParameter = new ArrayList<>();

}
