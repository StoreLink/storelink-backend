package kz.storelink.model.storage;

import com.fasterxml.jackson.annotation.JsonFormat;

import kz.storelink.model.Comment;
import kz.storelink.model.item.Item;
import kz.storelink.model.user.User;
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

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_id;

    @Column(
            name = "storage_name",
            nullable = false,
            length = 32,
            columnDefinition = "TEXT"
    )
    private String storage_name;

    @Column(
            name = "storage_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String storage_description;

    @Column(
            name = "storage_available_time",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String storage_available_time;

    @Column(
            name = "storage_image",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String storage_image;

    @Column(
            name = "storage_price",
            nullable = false
    )
    private Double storage_price;

    @Column(
            name = "storage_size",
            nullable = false
    )
    private Double storage_size;

    @Column(
            name = "storage_longitude",
            nullable = false
    )
    private Double storage_longitude;

    @Column(
            name = "storage_latitude",
            nullable = false
    )
    private Double storage_latitude;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate created_date;

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
