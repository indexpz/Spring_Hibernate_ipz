package pl.coderslab.app.domain.model;

import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="authors")
@Getter @Setter @ToString(exclude="books")
@AllArgsConstructor @NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", length = 225)
    private String firstName;
    @Column(name = "last_name",length = 225)
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();
}
