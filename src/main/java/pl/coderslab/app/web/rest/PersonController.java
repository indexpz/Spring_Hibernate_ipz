package pl.coderslab.app.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.app.domain.dao.PersonDao;
import pl.coderslab.app.domain.model.Person;
import pl.coderslab.app.domain.model.PersonDetails;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/add")
    public String add() {
        Person modelObject = new Person(null, "fire", "bird", "sss@sadfas.pl", null);
        PersonDetails details = new PersonDetails(null, "Jaś", "Kowalski", "Arabska", "12/12", "Kraków");
        modelObject.setDetails(details);
        personDao.save(modelObject);
        return "Zapisano person pod id " + modelObject.getId() ;
    }

    @GetMapping("/edit")
    public String edit(){
        Person modelObject = personDao.findById(1L);
        modelObject.setEmail("asdf@rety.pl");
        return personDao.update(modelObject).toString();
    }

    @GetMapping("/delete")
    public String delete(){
        Person modelObject = personDao.findById(1l);
       personDao.remove(modelObject);
       return "Usunięto person o id " + modelObject.getId();
    }

    @GetMapping("/get")
    public String get(){
        Person modelObject = personDao.findById(1l);
        return modelObject.toString();
    }

    @GetMapping("/all")
    public String all(){
        return personDao.findAll().stream()
                .map(Person::toString)
                .collect(Collectors.joining("\n"));
    }
}
