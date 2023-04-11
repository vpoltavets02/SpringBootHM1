package spring.boot.hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.boot.hometask.services.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {
    private final ItemsService itemsService;

    @Autowired
    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("items", itemsService.findAll());
        return "items/index";
    }
}