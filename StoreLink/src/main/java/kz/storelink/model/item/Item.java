package kz.storelink.model.item;

import com.fasterxml.jackson.annotation.JsonFormat;
import kz.storelink.model.storage.Storage;
import kz.storelink.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
public class Item implements Serializable {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    @NotNull
    @NotEmpty
    @Size(max = 64)
    private String item_name;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String item_description;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String item_image;

    @NotNull
    @NotEmpty
    private Long item_count;

    @NotNull
    @NotEmpty
    private Double item_size;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate item_uploadDate = LocalDate.now();

    // --- RELATIONS --- //

    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    // Relations between "Item and ItemCategory", "Item and User", "Item and Storage"
    // is @ManyToOne annotation linked through FK (Foreign Key)
    // Many items can take the same item category, users and storages
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_category_id", nullable = false, updatable = true)
    private ItemCategory itemCategory;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_id", nullable = true, updatable = true)
    private Storage storage;

}
