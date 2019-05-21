package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.PublisherService;

public class AuthorConverter implements Converter<String, Author> {
	@Autowired
	private AuthorDao dao;

	@Override
	public Author convert(String source) {
		Author author = dao.findById(Long.parseLong(source));
		return author;
	}
}
