package kz.storelink.model.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "storage_type")
@NoArgsConstructor
@AllArgsConstructor
public class StorageType implements Serializable {

    // --- COLUMNS --- //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storageTypeId;

    private String storageTypeName;
    private String storageTypeDescription;
    private String storageTypeImage;

    // --- RELATIONS --- //
    // Bidirectional Relations between "StorageType and Storage" is @OneToMany annotation linked through FK (Foreign Key)
    // One storage type has many storages
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Storage> storages;

}
