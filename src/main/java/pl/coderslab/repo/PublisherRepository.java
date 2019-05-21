package pl.coderslab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Publisher;


public interface PublisherRepository extends JpaRepository<PublisherRepository, Long>{

	Publisher findFirstByNip(String nip);
	Publisher findFirstByRegon(String regon);
}
