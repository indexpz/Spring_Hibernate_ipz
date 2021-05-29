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
@RequestMapping("/create-person")
public class CreatePersonController {

    private final PersonDao personDao;

    public CreatePersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public String prepare() {
        return "persons/create-form";
    }

    @PostMapping
    public String process(@RequestParam String login, @RequestParam String email, @RequestParam String password, Model model){
        Person person = new Person();
        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);
        personDao.save(person);
        model.addAttribute("person", person);
        return "persons/created";
    }



}
