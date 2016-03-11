package daos.library;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.library.Theme;

public interface ThemeDao extends JpaRepository<Theme, Integer> {
}
