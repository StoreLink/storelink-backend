package kz.storelink.model.storage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "storage")
@Data
@NoArgsConstructor
public class Storage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storageId;
    private String storageName;
    private String storageDescription;
    private String storageAvailableTime;
    private String storageImage;
    private Double storagePrice;
    private Double storageSize;
    private Double storageSizeOccupied;
    private Double storageLongitude;
    private Double storageLatitude;
    private Double storageRate;
    private Long userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updatedDate;

}
