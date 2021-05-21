package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.PublisherDao;

public class PublisherConverter implements Converter<String, Publisher> {
    @Autowired
    private PublisherDao publisherDao;

    @Override
    public Publisher convert(String source) {
        return publisherDao.findById(Integer.parseInt(source));
    }
}