package kz.storelink.model;

import kz.storelink.model.storage.Parameter;
import kz.storelink.model.storage.Storage;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "storage")
@Data
@NoArgsConstructor
public class Storage_Parameter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_parameter_id;

    @ManyToOne
    @MapsId("storage_id") //This is the name of attr in Storage class
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne
    @MapsId("parameter_id") //This is the name of attr in Parameter class
    @JoinColumn(name = "parameter_id")
    private Parameter parameter;

}
