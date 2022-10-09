package com.example.apirest.controllers;

import com.example.apirest.entities.Libro;
import com.example.apirest.services.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/libros")
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService){
        this.libroService = libroService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.findAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":Error! Porfavor intente de nuevo.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.findById(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": Error! No se encontró el recurso con el id especificado.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Libro entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":Error. No se pudo crear el recurso.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Libro entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.update(id, entity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":Error. Porfavor intente de nuevo.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(libroService.delete(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":Error. No se pudo eliminar el recurso.\"}");
        }
    }
}
