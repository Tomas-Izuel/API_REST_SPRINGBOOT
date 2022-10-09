package com.example.apirest.repositories;

import com.example.apirest.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends BaseRepository<Libro, Long> {
}
