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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storageParameterId;

    private Long storageId;
    private Long parameterId;

}
