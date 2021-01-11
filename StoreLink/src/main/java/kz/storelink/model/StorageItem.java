package kz.storelink.model;

import kz.storelink.model.item.Item;
import kz.storelink.model.storage.Storage;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "storage_item")
@Data
@NoArgsConstructor
public class StorageItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_item_id;

    // Join two Primary Keys into table StorageItem
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
