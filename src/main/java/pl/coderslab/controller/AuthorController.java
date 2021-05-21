package pl.coderslab.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.service.AuthorDao;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorDao authorDao;
    private final Logger logger;

    @Autowired
    public AuthorController(AuthorDao authorDao, Logger logger) {
        this.authorDao = authorDao;
        this.logger = logger;
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {

        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/update/{id}/{title}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName, String lastName) {
        Author author = authorDao.findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.update(author);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "deleted";
    }

    @RequestMapping("/author/all")
    @ResponseBody
    public String findAll() {
        List<Author> allAuthors = authorDao.findAll();
        allAuthors.forEach(author -> logger.info(author.toString()));
        return "findAllAuthors";
    }


}
