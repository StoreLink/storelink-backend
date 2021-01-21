package kz.storelink.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name = "user_details",
        uniqueConstraints = {
                @UniqueConstraint(name = "nin_unique", columnNames = "nin"),
                @UniqueConstraint(name = "email", columnNames = "email")
        }
)
@Data
@NoArgsConstructor
public class UserDetails {

    // --- COLUMNS --- //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_details_id;

    @Column(
            name = "nin",
            nullable = false,
            unique = true,
            length = 12,
            columnDefinition = "TEXT"
    )
    private String nin;

    @Column(
            name = "email",
            nullable = false,
            unique = true,
            length = 64,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "first_name",
            nullable = false,
            length = 64,
            columnDefinition = "TEXT"
    )
    private String first_name;

    @Column(
            name = "last_name",
            nullable = false,
            length = 64,
            columnDefinition = "TEXT"
    )
    private String last_name;

    @Column(
            name = "payment_card",
            length = 16,
            columnDefinition = "TEXT"
    )
    private String payment_card;

    @Column(
            name = "user_image",
            columnDefinition = "TEXT"
    )
    private String user_image;

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
