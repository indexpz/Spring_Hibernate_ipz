package pl.coderslab.app.web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.domain.dao.AuthorDao;
import pl.coderslab.app.domain.dao.BookDao;
import pl.coderslab.app.domain.dao.PublisherDao;
import pl.coderslab.app.domain.model.Author;
import pl.coderslab.app.domain.model.Book;
import pl.coderslab.app.domain.model.Publisher;

import java.util.List;

@Controller
@RequestMapping("/forms/book")
@Slf4j
//@RequiredArgsConstructor
public class BookFormController {

//    Zamiast tego co poniżej @Slf4j
//private static final Logger log = LoggerFactory.getLogger(BookFormController.class);

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;


    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @ModelAttribute("allPublishers")
    public List<Publisher> publishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("allAuthors")
    public List<Author> authors() {
        return authorDao.findAll();
    }


    @GetMapping("/list")
    public String prepareList(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "books/list";
    }

    @GetMapping("/create")
    public String prepareCrate(Model model) {
        model.addAttribute("book", new Book());
        return "books/create-form";
    }

    @PostMapping("/create")
    public String processCreate(Book book) {
        log.debug("Książka do zapisania " + book);
        bookDao.save(book);
        log.debug("Nadano id " + book.getId());
        log.debug("Książka po zapisie " + book);
        return "redirect:/forms/book/list";
    }


    @GetMapping("/edit")
    public String prepareEdit( String id, Model model){
        model.addAttribute("book", bookDao.findById(Long.parseLong(id)));
        return "/books/edit-form";
    }

    @PostMapping("/edit")
    public String processEdit(Book book){
        log.debug("-------- Książka do edycji " + book);
        bookDao.update(book);
        log.debug("-------- Książka po edycji " + book);
        return "redirect:/forms/book/list";
    }

    @GetMapping("/delete")
    public String prepareDelete(Long id, Model model){
        model.addAttribute("book", bookDao.findById(id));
        return "/books/confirm-delete";
    }

    @PostMapping("/delete")
    public String processDelete(Long id){
        Book book = bookDao.findById(id);
        log.debug("Usuwanie książki: " + book);
        bookDao.remove(book);
        log.info("Usunięto książkę: " + book);
        return "redirect:/forms/book/list";
    }
}
