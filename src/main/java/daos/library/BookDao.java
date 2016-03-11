package daos.library;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.library.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
}
