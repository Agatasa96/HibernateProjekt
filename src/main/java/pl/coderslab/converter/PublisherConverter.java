package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PublisherService;

public class PublisherConverter implements Converter<String, Publisher> {

	@Autowired
	private PublisherDao dao;

	@Override
	public Publisher convert(String source) {
		Publisher publisher = dao.findById(Long.parseLong(source));
		return publisher;
	}

}
