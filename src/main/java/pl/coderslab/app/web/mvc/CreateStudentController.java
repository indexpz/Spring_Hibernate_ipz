package pl.coderslab.app.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.domain.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/create-student")
public class CreateStudentController {

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "C++", "PHP", "Python");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return List.of("Java", "Java", "Java", "Java");
    }


    @GetMapping
    public String prepare(Model model) {
        model.addAttribute("student", new Student());
        return "students/create-form";
    }

    @PostMapping
    public String process(Student student) {
        return "students/crated";
    }
}
