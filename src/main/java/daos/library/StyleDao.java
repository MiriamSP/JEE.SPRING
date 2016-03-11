package daos.library;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.library.Style;

public interface StyleDao extends JpaRepository<Style, Integer> {
    Style findByNameIgnoreCase(String name);
}
