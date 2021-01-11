package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "storage_state")
@Data
@NoArgsConstructor
public class StorageState implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_state_id;

    @NotNull
    @NotEmpty
    private String storage_state_name;
    private String storage_state_description;

}
