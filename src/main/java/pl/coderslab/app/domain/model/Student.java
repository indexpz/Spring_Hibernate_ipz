package pl.coderslab.app.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String notes;
    boolean mailingList;
    List<String> programmingSkills;
    List<String> hobbies;

}
