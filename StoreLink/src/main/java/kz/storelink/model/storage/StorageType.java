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
@Table(name = "storage_type")
@Data
@NoArgsConstructor
public class StorageType implements Serializable {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_type_id;

    @NotNull
    @NotEmpty
    @Size(max = 32)
    @Column(unique = true)
    private String storage_type_name;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String storage_type_description;

    @NotNull
    @NotEmpty
    @Size(max = 64)
    private String storage_type_image;

    // --- RELATIONS --- //

    // Bidirectional Relations between "StorageType and Storage" is @OneToMany annotation linked through FK (Foreign Key)
    // One storage type has many storages
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "storage_id")
    private List<Storage> storages = new ArrayList<>();

}
