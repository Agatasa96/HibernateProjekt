package pl.coderslab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	Author findFirstByEmail(String email);

	Author findFirstByPesel(String pesel);

	List<Author> findByLastName(String lastName);

	@Query("SELECT a FROM Author a where a.email = ?1%")
	List<Author> findAuthWhereEmail(String email);

	@Query("SELECT a FROM Author a where a.pesel = ?1%")
	List<Author> findAuthWherePesel(String pesel);
}
