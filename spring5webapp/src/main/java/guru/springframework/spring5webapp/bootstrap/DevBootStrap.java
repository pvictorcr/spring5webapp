package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootStrap(AuthorRepository authorRepository, PublisherRepository publisherRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
		
	}

	private void initData() {
		
		//Eric
		Author eric = new Author("Eric", "Evans");
		Publisher hc = new Publisher("HarperCollins", "Rua do Arraial", "São Paulo", "São Paulo");
		Book ddd = new Book("Domain Driven Design", "1234", hc);
		eric.getBooks().add(ddd);
		
		//publisherRepository.save(hc);
		bookRepository.save(ddd);
		authorRepository.save(eric);
		
		//Rod
		Author rod = new Author("Rod", "Johnson");
		Publisher wbrx = new Publisher("WBRX", "Second Street", "Edmonton", "Arizona");
		Book noEJB = new Book("J2EE Development without EJB", "23444", wbrx);
		
		//publisherRepository.save(wbrx);
		bookRepository.save(noEJB);
		authorRepository.save(rod);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		initData();
	}
}
