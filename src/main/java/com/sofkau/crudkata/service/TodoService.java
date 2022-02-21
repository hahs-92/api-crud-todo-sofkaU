package com.sofkau.crudkata.service;

import com.sofkau.crudkata.entity.Todo;
import com.sofkau.crudkata.repository.ITodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final  ITodoRepository iTodoRepository;

    public TodoService(ITodoRepository iTodoRepository) {
        this.iTodoRepository = iTodoRepository;
    }

    public List<Todo> getAll() {
        return iTodoRepository.findAll();
    }

    public Optional<Todo> getById(Long id) {
        return iTodoRepository.findById(id);
    }

    public Todo create(Todo todo) {
        return iTodoRepository.save(todo);
    }

    public void delete(Long id) {
        iTodoRepository.deleteById(id);
    }

    public Todo update(Long id, Todo todo) {
        return iTodoRepository.findById(id)
                .map(t -> {
                    t.setName(todo.getName());
                    t.setCompleted(todo.isCompleted());

                    return t;
                }).orElse(null);

    }
}
