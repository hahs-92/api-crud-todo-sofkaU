package com.sofkau.crudkata.repository;

import com.sofkau.crudkata.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodoRepository  extends JpaRepository<Todo, String> {
}
