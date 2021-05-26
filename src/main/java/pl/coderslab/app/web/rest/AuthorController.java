package pl.coderslab.app.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.app.domain.dao.AuthorDao;
import pl.coderslab.app.domain.model.Author;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/add")
    public String add() {
        Author modelObject = new Author(null, "Jan", "Kowalski", new ArrayList<>());
        authorDao.save(modelObject);
        return "Zapisano autora pod id " + modelObject.getId() + " " + modelObject.getFirstName() + " " + modelObject.getLastName();
    }

    @GetMapping("/edit")
    public String edit(){
        Author modelObject = authorDao.findById(1L);
        modelObject.setFirstName("Adam");
        modelObject.setLastName("Słodowy");
        return authorDao.update(modelObject).toString();
    }

    @GetMapping("/delete")
    public String delete(){
        Author modelObject = authorDao.findById(1l);
       authorDao.remove(modelObject);
       return "Usunięto autora o id " + modelObject.getId();
    }

    @GetMapping("/get")
    public String get(){
        Author modelObject = authorDao.findById(1l);
        return modelObject.toString();
    }

    @GetMapping("/all")
    public String all(){
        return authorDao.findAll().stream()
                .map(Author::toString)
                .collect(Collectors.joining("\n"));
    }
}
