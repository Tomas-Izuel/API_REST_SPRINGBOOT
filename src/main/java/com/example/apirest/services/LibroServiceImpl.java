package com.example.apirest.services;

import com.example.apirest.entities.Libro;
import com.example.apirest.repositories.BaseRepository;
import com.example.apirest.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long>{
    @Autowired
    private LibroRepository libroRepository;

    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository) {
        super(baseRepository);
    }
}
