package kz.storelink.model.storage;

import kz.storelink.model.storage.Parameter;
import kz.storelink.model.storage.Storage;
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
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;
    @ManyToOne
    @JoinColumn(name = "parameter_id")
    private Parameter parameter;

}
