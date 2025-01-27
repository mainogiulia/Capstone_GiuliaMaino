package it.epicode.Capstone.menu;

import it.epicode.Capstone.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
