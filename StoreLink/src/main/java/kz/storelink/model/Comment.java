package kz.storelink.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String commentText;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate createdDate;

    private Long storageId;
    private Long userId;

}
