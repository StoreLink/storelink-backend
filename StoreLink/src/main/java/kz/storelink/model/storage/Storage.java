package kz.storelink.model.storage;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

import kz.storelink.model.Comment;
import kz.storelink.model.StorageItem;
import kz.storelink.model.UserStorage;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    // Relations between Storage and options is Many to One annotation linked through FK
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



    // Extra column Relation Many to Many Storage-Parameter, analogue for Comments(List), UserStorage, StorageItem
    @OneToMany(mappedBy = "storage_parameter_id")
    private final Set<StorageParameter> storageParameter = new HashSet<StorageParameter>();
    @OneToMany(mappedBy = "storage_item_id")
    private final Set<StorageItem> storageItem = new HashSet<StorageItem>();
    @OneToMany(mappedBy = "comment_id")
    private final Set<Comment> comment = new HashSet<Comment>();
    @OneToMany(mappedBy = "user_storage_id")
    private final Set<UserStorage> userStorage = new HashSet<UserStorage>();


    // One to Many Relation One Storage has Many Images
    @OneToMany(mappedBy = "storage_image_id")
    private final List<StorageImage> image = new ArrayList<StorageImage>();

}
