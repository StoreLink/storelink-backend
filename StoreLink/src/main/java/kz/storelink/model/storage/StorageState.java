package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "storage_state")
@Data
@NoArgsConstructor
public class StorageState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_state_id;

    @NotNull
    @NotEmpty
    private String storage_state_name;
    private String storage_state_description;

}
