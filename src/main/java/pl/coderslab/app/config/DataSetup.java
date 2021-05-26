package pl.coderslab.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.coderslab.app.domain.dao.AuthorDao;
import pl.coderslab.app.domain.dao.BookDao;
import pl.coderslab.app.domain.dao.PublisherDao;
import pl.coderslab.app.domain.model.Author;
import pl.coderslab.app.domain.model.Book;
import pl.coderslab.app.domain.model.Publisher;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Component
public class DataSetup {

    private static final Logger logger = LoggerFactory.getLogger(DataSetup.class);

    private AtomicBoolean alreadyRun = new AtomicBoolean(false);

    private final AuthorDao authorDao;
    private final BookDao bookDao;
    private final PublisherDao publisherDao;


    public DataSetup(AuthorDao authorDao, BookDao bookDao, PublisherDao publisherDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @EventListener
    public void testData(ContextRefreshedEvent event) {
        if (!alreadyRun.getAndSet(true)) {
            System.out.println("Aplikacja właśnie się uruchomiła i rozpoczynamy zabawę");
            publisherDao.save(new Publisher(null, "Publisher1", null));
            publisherDao.save(new Publisher(null, "Publisher2", null));
            authorDao.save(new Author(null, "Author1", "Author1", null));
            authorDao.save(new Author(null, "Author2", "Author2", null));
            authorDao.save(new Author(null, "Author3", "Author3", null));

            Publisher publisher1 = publisherDao.findById(1L);
            Publisher publisher2 = publisherDao.findById(2L);
            Author author1 = authorDao.findById(1L);
            Author author2 = authorDao.findById(2L);
            Author author3 = authorDao.findById(3L);

            bookDao.save(new Book(null, "Book1", 5, "Description1", publisher1, List.of(author1, author2)));
            bookDao.save(new Book(null, "Book2", 6, "Description2", publisher2, List.of(author2, author3)));

//            logger.debug("--- Wszystkie książki:");
//            logger.debug(bookDao.findAll().stream().map(Book::toString).collect(Collectors.joining("\n")));
//            logger.debug("--- Dla wydawcy: " + publisher1);
//            logger.debug(bookDao.findAllByPublisher(publisher1).stream().map(Book::toString).collect(Collectors.joining("\n")));
//            logger.debug("--- Dla id wydawcy: " + publisher1.getId());
//            logger.debug(bookDao.findAllByPublisher(publisher1.getId()).stream().map(Book::toString).collect(Collectors.joining("\n")));
//            logger.debug("--- Dla autora: " + author1);
//            logger.debug(bookDao.findAllByAuthor(author1).stream().map(Book::toString).collect(Collectors.joining("\n")));
//            logger.debug("--- Dla autora: " + author2);
//            logger.debug(bookDao.findAllByAuthor(author2).stream().map(Book::toString).collect(Collectors.joining("\n")));
        }

    }


}