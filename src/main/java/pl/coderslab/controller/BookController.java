package pl.coderslab.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.BookDao;
import pl.coderslab.service.PublisherDao;

import java.util.List;

@Controller
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final List<Publisher> publishers;
    private final Logger logger;

    @Autowired
    public BookController(BookDao bookDao, PublisherDao publisherDao, List<Publisher> publishers, Logger logger) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.publishers = publishers;
        this.logger = logger;
    }

    @RequestMapping("/book/add")
    @ResponseBody
    public String hello() {
        Publisher publisher = new Publisher();
        publisher.setName("publisher");
        publisherDao.savePublisher(publisher);
        Book book = new Book();
        book.setTitle("Thinking in Java");
//        book.setAuthor("Bruce Eckel");
        book.setRating(4);
        book.setPublishers(publishers);
        book.setDescription("Myśl w Java");
        bookDao.saveBook(book);
        return "Id dodanej książki to:" + book.getId();
    }


//    @RequestMapping("/book/get/{id}")
//    @ResponseBody
//    public Book getBook(@PathVariable Long id) {
//        return this.bookService.findById(id).orElseThrow(() -> {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
//        });
//    }

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }

    @RequestMapping("/book/all")
    @ResponseBody
    public String findAll() {
        List<Book> all = bookDao.findAll();
        all.forEach(book -> logger.info(book.toString()));
        return "findAllBooks";
    }


    @RequestMapping("/book/findAllBooksWithEnyPublisher")
    @ResponseBody
    public String findAllBooksWithEnyPublisher() {
        List<Book> all = bookDao.findAllBooksWithEnyPublisher();
        all.forEach(book -> logger.info(book.toString()));
        return "findAllBooksWithEnyPublisher";
    }


    @RequestMapping("/book/findAllBooksWithEnyPublisher")
    @ResponseBody
    public String findAllBooksWithThisPublisher(Publisher publisher) {
        List<Book> all = bookDao.findAllBooksWithThisPublisher(publisher);
        all.forEach(book -> logger.info(book.toString()));
        return "findAllBooksWithThisPublisher";
    }

    @RequestMapping("/book/findAllBooksWithThisAuthor")
    @ResponseBody
    public String findAllBooksWithThisAuthor(Author author) {
        List<Book> all = bookDao.findAllBooksWithThisAuthor(author);
        all.forEach(book -> logger.info(book.toString()));
        return "findAllBooksWithThisAuthor";
    }
}
