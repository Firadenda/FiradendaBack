package com.Firadenda.FiradendaBack.controller;

import java.util.List;
import java.util.Optional;

import com.Firadenda.FiradendaBack.entity.Item;
import com.Firadenda.FiradendaBack.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id) {
        return itemRepository.findById(id);
    }

    @PostMapping("")
    public Item createItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PutMapping("/{id}/updateStock")
    public ResponseEntity<?> updateItemStock(@PathVariable Long id, @RequestParam Integer newStock) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setStock(newStock);
            itemRepository.save(item);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item existingItem = optionalItem.get();
            existingItem.setName(item.getName());
            existingItem.setPrice(item.getPrice());
            existingItem.setCategory(item.getCategory());
            existingItem.setDescription(item.getDescription());
            existingItem.setImage(item.getImage());
            existingItem.setStock(item.getStock());
            return itemRepository.save(existingItem);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }

    @DeleteMapping("")
    public void deleteAllItems() {
        itemRepository.deleteAll();
    }
}
