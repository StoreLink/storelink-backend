package kz.storelink.model.item;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "item_category")
@Data
@NoArgsConstructor
public class ItemCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_category_id;

    @NotNull
    @NotEmpty
    private String item_category_name;
    private String item_category_description;
    private String item_category_image;

}
