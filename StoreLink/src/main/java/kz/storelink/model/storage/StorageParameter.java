package kz.storelink.model.storage;

import kz.storelink.model.storage.Parameter;
import kz.storelink.model.storage.Storage;
import kz.storelink.model.user.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "storage_parameter")
@Data
@NoArgsConstructor
public class StorageParameter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_parameter_id;

    // Join two Primary Keys into table StorageParameter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_id", nullable = true, updatable = true)
    private Storage storage;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parameter_id", nullable = true, updatable = true)
    private Parameter parameter;

}
