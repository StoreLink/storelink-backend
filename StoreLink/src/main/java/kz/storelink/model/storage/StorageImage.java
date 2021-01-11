package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static java.lang.System.currentTimeMillis;

@Entity
@Table(name = "storage_image")
@Data
@NoArgsConstructor
public class StorageImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_image_id;

    // Write down into Image - Current time From Year to Millisecond
    // Convert Long into String
    // currentTimeMillis() function output: 210106113723
    @NotNull
    @NotEmpty
    private String storage_image_name = String.valueOf(currentTimeMillis());

}
