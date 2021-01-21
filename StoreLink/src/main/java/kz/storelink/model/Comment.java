package kz.storelink.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import kz.storelink.model.storage.Storage;
import kz.storelink.model.user.User;
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

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    @Column(
            name = "comment_text",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String comment_text;

    @Column(
            name = "rate"
    )
    private Double rate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate created_date;

    // --- RELATIONS --- //

    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    // Relations between "Comment and User", "Comment and Storage"
    // is @ManyToOne annotation linked through FK (Foreign Key)
    // Many comments can take the same user, storage
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_id", nullable = false, updatable = false)
    private Storage storage;






}
