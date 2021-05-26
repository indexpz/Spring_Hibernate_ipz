package pl.coderslab.app.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person_details")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String street;
    @Column(name = "street_number")
    private String streetNumber;
    @Column
    private String city;
}
