package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parameter")
@Data
@NoArgsConstructor
public class Parameter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parameter_id;

    @NotNull
    @NotEmpty
    private String parameter_name;
    private String parameter_img;

    // Extra column Relation Many to Many Storage-Parameter
    @OneToMany(mappedBy = "storage_parameter_id")
    private Set<StorageParameter> storageParameter = new HashSet<StorageParameter>();

}
