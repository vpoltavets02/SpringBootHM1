package spring.boot.hometask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.hometask.models.Item;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {

}
