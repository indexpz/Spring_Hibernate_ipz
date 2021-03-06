package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @Autowired
    public BookController(BookDao bookDao, PublisherDao publisherDao, List<Publisher> publishers) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.publishers = publishers;
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

}
