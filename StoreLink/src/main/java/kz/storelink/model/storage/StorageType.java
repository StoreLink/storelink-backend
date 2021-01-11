package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "storage_type")
@Data
@NoArgsConstructor
public class StorageType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_type_id;

    @NotNull
    @NotEmpty
    private String storage_type_name;
    private String storage_type_description;

}
