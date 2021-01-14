package kz.storelink.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_description")
@Data
@NoArgsConstructor
public class UserDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_description_id;

    @NotNull
    @NotEmpty
    private String fullname;
    private String email;
    private String nin;
    private String user_image;
    private String payment_card;

}
