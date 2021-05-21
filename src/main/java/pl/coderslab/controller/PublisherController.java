package pl.coderslab.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.PublisherDao;

import java.util.List;

@Controller
public class PublisherController {

    private final PublisherDao publisherDao;
    private final Logger logger;

    @Autowired
    public PublisherController(PublisherDao publisherDao, Logger logger) {
        this.publisherDao = publisherDao;
        this.logger = logger;
    }


    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/publisher/update/{id}/{title}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String name) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }


    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "deleted";
    }

    @RequestMapping("/publisher/all")
    @ResponseBody
    public String findAllPublishers() {
        List<Publisher> allPublishers = publisherDao.findAll();
        allPublishers.forEach(publisher -> logger.info(publisher.toString()));
        return "findAllPublishers";
    }

}
