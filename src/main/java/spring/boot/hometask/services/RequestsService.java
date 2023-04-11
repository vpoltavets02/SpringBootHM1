package spring.boot.hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.hometask.models.Request;
import spring.boot.hometask.repositories.ItemsRepository;
import spring.boot.hometask.repositories.RequestsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class RequestsService {
    private final RequestsRepository requestsRepository;
    private final ItemsRepository itemsRepository;

    @Autowired
    public RequestsService(RequestsRepository requestsRepository, ItemsRepository itemsRepository) {
        this.requestsRepository = requestsRepository;
        this.itemsRepository = itemsRepository;
    }

    public List<Request> findAll() {
        return requestsRepository.findAll();
    }

    public Request findById(int id) {
        Optional<Request> order = requestsRepository.findById(id);
        return order.orElse(null);
    }

    @Transactional
    public void save(Request order) {
        requestsRepository.save(order);
    }

    public void saveItems(Request request, List<String> strings) {
        if (request.getItems() == null)
            request.setItems(new ArrayList<>());
        request.setItems(strings.stream()
                .map(s -> itemsRepository.findById(Integer.parseInt(s)).orElse(null))
                .collect(Collectors.toList()));
    }
}