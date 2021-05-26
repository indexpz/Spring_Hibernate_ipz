package pl.coderslab.app.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Getter
@Setter
@ToString(exclude = {"password"})
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private PersonDetails details = new PersonDetails();
}
