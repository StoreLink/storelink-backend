package kz.storelink.model.storage;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "storage_category")
@Data
@NoArgsConstructor
public class StorageCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_category_id;

    @NotNull
    @NotEmpty
    private String storage_category_name;
    private String storage_category_description;

}
