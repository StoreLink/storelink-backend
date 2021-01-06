package kz.storelink.model.storage;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "storage")
@Data
@NoArgsConstructor
public class Storage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_id;

    @NotNull
    @NotEmpty
    private String storage_name;
    private String storage_description;
    private Double storage_price;
    private Double storage_size;
    private Double storage_longitude;
    private Double storage_latitude;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate created_date = LocalDate.now();
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    // Relations between Storage and options is Man to One annotation linked through FK
    // Many storages can take the same option
    @ManyToOne
    @JoinColumn(name = "storage_available_time_id")
    private StorageAvailableTime storageAvailableTime;
    @ManyToOne
    @JoinColumn(name = "storage_category_id")
    private StorageCategory storageCategory;
    @ManyToOne
    @JoinColumn(name = "storage_state_id")
    private StorageState storageState;
    @ManyToOne
    @JoinColumn(name = "storage_type_id")
    private StorageType storageType;

    // Relation with Images One to Many, Images type is "LIST"
    @OneToMany(mappedBy = "storage")
    private final List<StorageImage> images = new ArrayList<StorageImage>();
}
