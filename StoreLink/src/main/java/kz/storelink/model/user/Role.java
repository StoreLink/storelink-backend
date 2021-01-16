package kz.storelink.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
public class Role implements Serializable {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    @NotNull
    @NotEmpty
    @Size(max = 64)
    @Column(unique = true)
    private String role_name,
            role_description;

    // --- RELATIONS --- //

    // Bidirectional Relations between "Role and User" is @OneToMany annotation linked through FK (Foreign Key)
    // One Role has many Users
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user_id")
    private List<User> users = new ArrayList<>();

}
