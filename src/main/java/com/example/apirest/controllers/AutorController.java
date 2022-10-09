package com.example.apirest.controllers;

import com.example.apirest.entities.Autor;
import com.example.apirest.services.AutorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/autores")
public class AutorController {
    private final AutorServiceImpl autorServiceImpl;

    public AutorController(AutorServiceImpl autorServiceImpl) {
        this.autorServiceImpl = autorServiceImpl;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(autorServiceImpl.findAll());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":Error! Porfavor intente de nuevo.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne (@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(autorServiceImpl.findById(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":Error! No se encontró el recurso con el id especificado.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Autor entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(autorServiceImpl.save(entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":Error. No se pudo crear el recurso.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Autor entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(autorServiceImpl.update(id, entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":Error. Porfavor intente de nuevo.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(autorServiceImpl.delete(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":Error. No se pudo eliminar el recurso.\"}");
        }
    }
}
