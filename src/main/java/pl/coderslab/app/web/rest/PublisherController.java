package pl.coderslab.app.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.app.domain.dao.BookDao;
import pl.coderslab.app.domain.dao.PublisherDao;
import pl.coderslab.app.domain.model.Publisher;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/add")
    public String add() {
        Publisher modelObject = new Publisher(null, "Słowo", new ArrayList<>());
        publisherDao.save(modelObject);
        return "Zapisano pod id " + modelObject.getId();
    }

    @GetMapping("/edit")
    public String edit() {
        Publisher modelObject = publisherDao.findById(1L);
        modelObject.setName("nowa nazwa");
        return publisherDao.update(modelObject).toString();
    }

    @GetMapping("delete")
    public String delete() {
        Publisher modelObject = publisherDao.findById(1L);
        publisherDao.remove(modelObject);
        return "Usunięto wydawcę o id " + modelObject.getId();
    }

    @GetMapping("/get")
    public String get() {
        Publisher modelObject = publisherDao.findById(1L);
        return modelObject.toString();
    }

    @GetMapping("/all")
    public String all(){
        return publisherDao.findAll().stream()
                .map(Publisher::toString)
                .collect(Collectors.joining("\n"));
    }
}
