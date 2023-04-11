package spring.boot.hometask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.hometask.models.Request;

@Repository
public interface RequestsRepository extends JpaRepository<Request, Integer> {
}
