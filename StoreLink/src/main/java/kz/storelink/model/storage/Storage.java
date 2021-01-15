package kz.storelink.model.storage;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

import kz.storelink.model.Comment;
import kz.storelink.model.item.Item;
import kz.storelink.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "storage")
@Data
@NoArgsConstructor
public class Storage implements Serializable {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_id;

    @NotNull
    @NotEmpty
    @Size(max = 64)
    private String storage_name;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String storage_description;

    @NotNull
    @NotEmpty
    private Double storage_price;

    @NotNull
    @NotEmpty
    private Double storage_size;

    @NotNull
    @NotEmpty
    private Double storage_longitude;
    @NotNull
    @NotEmpty
    @Size(max = 64)
    private Double storage_latitude;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private Double storage_available_time;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate created_date = LocalDate.now();

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private Double storage_image;

    // --- RELATIONS --- //

    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    // Relations between "Storage and StorageCategory", "Storage and StorageState", "Storage and StorageType"
    // is @ManyToOne annotation linked through FK (Foreign Key)
    // Many storages can take the same option
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_category_id", nullable = false, updatable = true)
    private StorageCategory storageCategory;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_state_id", nullable = false, updatable = true)
    private StorageState storageState;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_type_id", nullable = false, updatable = true)
    private StorageType storageType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    // Extra column Relation Many to Many Storage-Parameter, analogue for Comments(List), UserStorage, StorageItem
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "storage_parameter_id")
    private List<StorageParameter> storageParameter = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item_id")
    private List<Item> items = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "comment_id")
    private List<Comment> comments = new ArrayList<>();

}
