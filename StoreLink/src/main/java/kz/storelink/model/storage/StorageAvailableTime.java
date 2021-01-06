package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "storage_available_time")
@Data
@NoArgsConstructor
public class StorageAvailableTime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_available_time_id;

    @NotNull
    @NotEmpty
    private String storage_available_time_name;
    private String storage_available_time_description;

}
