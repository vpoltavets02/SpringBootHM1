package spring.boot.hometask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.hometask.models.Client;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Integer> {
}