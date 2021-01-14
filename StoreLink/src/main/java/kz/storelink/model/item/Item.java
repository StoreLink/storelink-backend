package kz.storelink.model.item;

import com.fasterxml.jackson.annotation.JsonFormat;
//import kz.storelink.model.storage.Storage;
//import kz.storelink.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    @NotNull
    @NotEmpty
    private String item_name;
    private String item_description;
    private String item_image;
    private Long item_count;
    private Double item_size;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate item_uploadDate = LocalDate.now();

    // Relations between Two Entity is Many to One annotation linked through FK (Foreign Key)
    // Many items can take the same category
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_category_id", nullable = false, updatable = true)
    private ItemCategory itemCategory;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", nullable = false, updatable = false)
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "storage_id", nullable = true, updatable = true)
//    private Storage storage;

}
