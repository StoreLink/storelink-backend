package kz.storelink.model.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "storage_category")
@NoArgsConstructor
@AllArgsConstructor
public class StorageCategory implements Serializable {

    // --- COLUMNS --- //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storageCategoryId;

    private String storageCategoryName;
    private String storageCategoryDescription;
    private String storageCategoryImage;

    // --- RELATIONS --- //
    // Bidirectional Relations between "StorageCategory and Storage" is @OneToMany annotation linked through FK (Foreign Key)
    // One storage category has many storages
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Storage> storages;

}
