package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "parameter")
@Data
@NoArgsConstructor
public class Parameter implements Serializable {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parameter_id;

    @NotNull
    @NotEmpty
    @Size(max = 32)
    @Column(unique = true)
    private String parameter_name;

    @NotNull
    @NotEmpty
    @Size(max = 64)
    private String parameter_img;

    // --- RELATIONS --- //


    // Bidirectional Relations between "Parameter and StorageParameter" is @OneToMany annotation linked through FK (Foreign Key)
    // One StorageParameter has many Parameters
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    // Extra column Relation Many to Many Storage-Parameter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "storage_parameter_id")
    private List<StorageParameter> storageParameter = new ArrayList<>();

}
