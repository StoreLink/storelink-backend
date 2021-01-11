package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;

import static java.lang.System.currentTimeMillis;

@Entity
@Table(name = "storage_image")
@Data
@NoArgsConstructor
public class StorageImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_images_id;

    private Storage storage;

    // Write down into Image - Current time From Year to Millisecond
    // Convert Long into String
    // currentTimeMillis() function output: 210106113723
    @NotNull
    @NotEmpty
    private String storage_images_name = String.valueOf(currentTimeMillis());

//    // Leave the standard column name of the table
//    @ManyToOne
//    public Storage getStorage() {
//        return storage;
//    }
//
//    public void setStorage(Storage storage) {
//        this.storage = storage;
//    }

}
