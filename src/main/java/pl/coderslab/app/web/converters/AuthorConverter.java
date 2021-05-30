package pl.coderslab.app.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.app.domain.dao.AuthorDao;
import pl.coderslab.app.domain.model.Author;

public class AuthorConverter implements Converter<String, Author> {

    private AuthorDao authorDao;

    @Autowired
    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author convert(String s) {
        return authorDao.findById(Long.parseLong(s));
    }
}
