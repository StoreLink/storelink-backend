package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "storage_parameter")
@Data
@NoArgsConstructor
public class StorageParameter implements Serializable {

    // --- COLUMNS --- //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_parameter_id;

    // --- RELATIONS --- //

    // Join two Primary Keys into table StorageParameter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_id", nullable = false, updatable = false)
    private Storage storage;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parameter_id", nullable = false)
    private Parameter parameter;

}
