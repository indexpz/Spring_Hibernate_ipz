package pl.coderslab.app.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.app.domain.dao.PersonDao;
import pl.coderslab.app.domain.model.Person;

@Controller
@RequestMapping("/create-person-with-spring-form")
public class CreatePersonControllerWithSpring {

    private final PersonDao personDao;

    public CreatePersonControllerWithSpring(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public String prepare(Model model) {
        model.addAttribute("person", new Person());
        return "persons/create-form-with-spring";
    }

    @PostMapping
    public String process(Person person) {
        personDao.save(person);
        return "persons/created";
    }


}
