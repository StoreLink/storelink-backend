package kz.storelink.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_details")
@Data
@NoArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_details_id;

    @NotNull
    @NotEmpty
    @Size(max = 12)
    @Column(unique = true)
    private String nin;

    @NotNull
    @NotEmpty
    @Size(max = 32)
    private String first_name;

    @NotNull
    @NotEmpty
    @Size(max = 32)
    private String last_name;

    @Size(max = 64)
    private String email;

    @Size(max = 64)
    private String user_image;

    @Size(max = 16)
    private String payment_card;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    // --- RELATIONS --- //

    // Relations between User and UserDetail is @OneToOne
    // One user has one detail
    // LAZY = fetch when needed, Cascade = update data in entity without affecting it
    // mappedBy is look for a field named user in the UserDetails entity
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
