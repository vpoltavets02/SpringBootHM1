package spring.boot.hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.boot.hometask.models.Client;
import spring.boot.hometask.services.ClientsService;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients")
public class ClientsController {
    private final ClientsService clientsService;

    @Autowired
    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("clients", clientsService.findAll());
        return "clients/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Client client = clientsService.findById(id);
        model.addAttribute("client", client);
        model.addAttribute("requests", client.getRequests());
        return "clients/show";
    }

    @GetMapping("/new")
    public String newClient(@ModelAttribute("client") Client client) {
        return "clients/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("client") @Valid Client client,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "clients/new";

        clientsService.save(client);
        return "redirect:/clients";
    }
}