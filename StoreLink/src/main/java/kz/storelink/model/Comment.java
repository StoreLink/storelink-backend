package kz.storelink.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import kz.storelink.model.storage.Storage;
import kz.storelink.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    @NotNull
    @NotEmpty
    private String comment_text;
    private Double rate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate created_date = LocalDate.now();

    // Join two Primary Keys into table Comment
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
