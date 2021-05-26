package pl.coderslab.app.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.app.domain.dao.AuthorDao;
import pl.coderslab.app.domain.dao.BookDao;
import pl.coderslab.app.domain.dao.PublisherDao;
import pl.coderslab.app.domain.model.Author;
import pl.coderslab.app.domain.model.Book;
import pl.coderslab.app.domain.model.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/add")
    public String add() {
        Publisher publisher = new Publisher(null, "gościu", new ArrayList<>());
        publisherDao.save(publisher);

        Author firstAuthor = authorDao.findById(1L);
        Author secondAuthor = authorDao.findById(2L);

        Book modelObject = new Book(null, "Book", 5, "Description", publisher, List.of(firstAuthor, secondAuthor));
        bookDao.save(modelObject);
        return "Zapisano pod id = " + modelObject.getId() + " " + modelObject.getTitle() + " " + modelObject.getDescription();
    }


    @GetMapping("/edit")
    public String edit() {
        Book modelObject = bookDao.findById(1L);
        modelObject.setTitle("Nowy tytuł");
        return bookDao.update(modelObject).toString();
    }

    @GetMapping("/delete")
    public String delete() {
        Book objectModel = bookDao.findById(1L);
        bookDao.remove(objectModel);
        return "Usunięto książkę o id " + objectModel.getId();
    }

    @GetMapping("/get")
    public String get() {
        Book modelObejct = bookDao.findById(1L);
        return modelObejct.toString();
    }

    @GetMapping("/all")
    private String all() {
        return bookDao.findAll().stream()
                .map(Book::toString)
                .collect(Collectors.joining("\n"));
    }
}
