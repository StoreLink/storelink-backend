package kz.storelink.model.storage;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "storage")
@Data
@NoArgsConstructor
public class Storage {

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
    private String storage_available_time;

    //Upload List of Photos by URL's of photo
//    @OneToMany
//    List<StorageImages> storage_images;
    @ToString.Exclude
    @OneToMany(mappedBy = "storage")
    private List<StorageType> storage_type;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate created_date = LocalDate.now();

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    private double rate;
    private int count;

}
