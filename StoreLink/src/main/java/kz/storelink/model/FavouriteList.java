package kz.storelink.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "favourite_list")
@Data
@NoArgsConstructor
public class FavouriteList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favouriteListId;

}
