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
@Table(name = "storage_category")
@Data
@NoArgsConstructor
public class StorageCategory implements Serializable {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_category_id;

    @NotNull
    @NotEmpty
    @Size(max = 32)
    @Column(unique = true)
    private String storage_category_name;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String storage_category_description;

    @NotNull
    @NotEmpty
    @Size(max = 64)
    private String storage_category_image;

    // --- RELATIONS --- //

    // Bidirectional Relations between "StorageCategory and Storage" is @OneToMany annotation linked through FK (Foreign Key)
    // One storage category has many storages
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "storage_id")
    private List<Storage> storages = new ArrayList<>();

}
