package pl.coderslab.app.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="publishers")
@Getter @Setter @ToString(exclude = {"books"})
@AllArgsConstructor @NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String name;

    @OneToMany
    private List<Book> books = new ArrayList<>();
}
