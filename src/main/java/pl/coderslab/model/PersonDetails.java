package pl.coderslab.model;

import javax.persistence.*;

@Entity
@Table(name = "person_details")
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String firstName;
    @Column(length = 100)
    private String lastName;
    @Column
    private int streetNumber;
    @Column(length = 100)
    private String street;
    @Column(length = 100)
    private String city;
}
