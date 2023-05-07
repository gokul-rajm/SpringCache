package springCache.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springCache.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}

