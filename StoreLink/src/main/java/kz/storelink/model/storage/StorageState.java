package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "storage_state",
        uniqueConstraints = {
                @UniqueConstraint(name = "storage_state_name_unique", columnNames = "storage_state_name")
        }
)
@Data
@NoArgsConstructor
public class StorageState implements Serializable  {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_state_id;

    @Column(
            name = "storage_state_name",
            nullable = false,
            unique = true,
            length = 32,
            columnDefinition = "TEXT"
    )
    private String storage_state_name;

    @Column(
            name = "storage_state_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String storage_state_description;

    @Column(
            name = "storage_state_image",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String storage_state_image;

    // --- RELATIONS --- //

    // Bidirectional Relations between "StorageState and Storage" is @OneToMany annotation linked through FK (Foreign Key)
    // One storage state has many storages
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "storage_id")
    private List<Storage> storages = new ArrayList<>();

    public StorageState(Long storage_state_id) {
        this.storage_state_id = storage_state_id;
    }

    public Long getStorage_state_id() {
        return storage_state_id;
    }

    public void setStorage_state_id(Long storage_state_id) {
        this.storage_state_id = storage_state_id;
    }
}
