package spring.boot.hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.boot.hometask.models.Request;
import spring.boot.hometask.services.ClientsService;
import spring.boot.hometask.services.ItemsService;
import spring.boot.hometask.services.RequestsService;

import java.util.List;

@Controller
@RequestMapping("/requests")
public class RequestsController {
    private final RequestsService requestsService;
    private final ClientsService clientsService;
    private final ItemsService itemsService;

    @Autowired
    public RequestsController(RequestsService requestsService, ClientsService clientsService, ItemsService itemsService) {
        this.requestsService = requestsService;
        this.clientsService = clientsService;
        this.itemsService = itemsService;
    }

    @GetMapping()
    public String index(Model model) {
        System.out.println(requestsService.findAll());
        model.addAttribute("requests", requestsService.findAll());
        return "requests/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Request request = requestsService.findById(id);
        model.addAttribute("request", request);
        model.addAttribute("items", request.getItems());
        return "requests/show";
    }

    @GetMapping("/new")
    public String newRequest(@ModelAttribute("request") Request request, Model model) {
        model.addAttribute("clients", clientsService.findAll());
        model.addAttribute("items", itemsService.findAll());
        return "requests/new";
    }

    @PostMapping()
    public String create(@RequestParam("clientId") String id,
                         @RequestParam("checkedItems") List<String> items) {
        Request request = new Request(clientsService.findById(Integer.parseInt(id)));
        requestsService.saveItems(request, items);
        requestsService.save(request);
        return "redirect:/requests";
    }
}