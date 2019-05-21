package pl.coderslab.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

public interface BookRepository extends JpaRepository<Book, Long>, Book2Repository {

	List<Book> findByTitle(String title);

	List<Book> findByCategory(Category category);

	List<Book> findByCategoryId(Long id);

	List<Book> findByAuthors(Author author);

	List<Book> findByPublisher(Publisher publisher);

	List<Book> findByRating(int rating);

	Book findFirstByCategory(Category category);
	
	@Query("SELECT b FROM Book b WHERE b.title = ?1")
	List<Book> findAllBooksWithTitle(String title);
	@Query("SELECT b FROM Book b WHERE b.category = ?1")
	List<Book> findAllBooksWithCategory(Category category);

	@Query("SELECT b FROM Book b WHERE b.rating >3 and b.rating<5")
	List<Book> findAllBooksWhereRating();
	

	@Query("SELECT b FROM Book b WHERE b.publisher = ?1")
	List<Book> findAllBooksWhereAuthor(Publisher publisher);
	
	@Query("SELECT b FROM Book b WHERE b.category= ?1 order by b.title ASC")
	Book findFirstBookWhereCategory(Category category);
	
	
}
