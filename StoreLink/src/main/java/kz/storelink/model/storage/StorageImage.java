package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;

@Entity
@Table(name = "storage_image")
@Data
@NoArgsConstructor
public class StorageImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_images_id;

    private Storage storage;

    @NotNull
    @NotEmpty
    private String storage_images_name;

    @ManyToOne
    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }


    //private Set<StorageImage> storageImage = new HashSet<>();
}
