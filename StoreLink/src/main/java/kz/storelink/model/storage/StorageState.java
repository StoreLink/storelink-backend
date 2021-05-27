package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "storage_state")
@Data
@NoArgsConstructor
public class StorageState implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storageStateId;

    private String storageStateName;
    private String storageStateDescription;

    // --- RELATIONS --- //
    // Bidirectional Relations between "StorageType and Storage" is @OneToMany annotation linked through FK (Foreign Key)
    // One storage type has many storages
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Storage> storages;

}
