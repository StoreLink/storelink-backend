package kz.storelink.model.item;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
    private Long item_count;
    private Double item_size;

    @ManyToOne
    @JoinColumn(name = "item_category_id")
    private ItemCategory itemCategory;
}
