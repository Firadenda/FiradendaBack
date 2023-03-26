package com.Firadenda.FiradendaBack.controller;

import com.Firadenda.FiradendaBack.entity.Command;
import com.Firadenda.FiradendaBack.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/command")
public class CommandController {

    @Autowired
    CommandRepository commandRepository;

    @GetMapping("")
    public List<Command> getAllCommands() {
        return commandRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Command> getCommandById(@PathVariable Long id) {
        Optional<Command> command = commandRepository.findById(id);
        return command.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCommand(@RequestBody Command command) {
        try {
            commandRepository.save(command);
            return ResponseEntity.ok("Command created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating command: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCommand(@PathVariable Long id, @RequestBody Command command) {
        Optional<Command> optionalCommand = commandRepository.findById(id);
        if (optionalCommand.isPresent()) {
            command.setId(id);
            commandRepository.save(command);
            return ResponseEntity.ok("Command updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommand(@PathVariable Long id) {
        Optional<Command> optionalCommand = commandRepository.findById(id);
        if (optionalCommand.isPresent()) {
            commandRepository.delete(optionalCommand.get());
            return ResponseEntity.ok("Command deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
