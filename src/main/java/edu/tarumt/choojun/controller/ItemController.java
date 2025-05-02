package edu.tarumt.choojun.controller;

import edu.tarumt.choojun.model.Item;
import edu.tarumt.choojun.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/list")
    public String listItems(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "jsp/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("item", new Item());
        return "jsp/create";
    }

    @PostMapping("/create")
    public String createItem(@ModelAttribute("item") Item item) {
        itemService.addItem(item);
        return "redirect:/items/list";
    }

    @GetMapping("/view/{id}")
    public String viewItem(@PathVariable("id") Long id, Model model) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            model.addAttribute("item", item);
            return "jsp/view";
        } else {
            return "redirect:/items/list"; // Or handle not found scenario
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            model.addAttribute("item", item);
            return "jsp/edit";
        } else {
            return "redirect:/items/list"; // Or handle not found scenario
        }
    }

    @PostMapping("/edit")
    public String updateItem(@ModelAttribute("item") Item item) {
        itemService.updateItem(item);
        return "redirect:/items/list";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable("id") Long id, Model model) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            model.addAttribute("item", item);
            return "jsp/delete";
        } else {
            return "redirect:/items/list"; // Or handle not found scenario
        }
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestParam("id") Long id) {
        itemService.deleteItem(id);
        return "redirect:/items/list";
    }
}