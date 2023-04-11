package spring.boot.hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.hometask.models.Client;
import spring.boot.hometask.repositories.ClientsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ClientsService {
    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public List<Client> findAll() {
        return clientsRepository.findAll();
    }

    public Client findById(int id) {
        Optional<Client> client = clientsRepository.findById(id);
        return client.orElse(null);
    }

    @Transactional
    public void save(Client client) {
        clientsRepository.save(client);
    }
}