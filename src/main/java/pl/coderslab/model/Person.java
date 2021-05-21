package pl.coderslab.model;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String login;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(length = 100, nullable = false)
    private String email;
    @OneToOne
    @JoinColumn(name = "details_id", unique = true)
    private PersonDetails personDetails;
}
