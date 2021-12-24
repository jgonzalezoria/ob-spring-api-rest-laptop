package com.jgonzalezoria.obspringapirestlaptop.controller;

import com.jgonzalezoria.obspringapirestlaptop.entities.Laptop;
import com.jgonzalezoria.obspringapirestlaptop.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    // atributos
    private LaptopRepository laptopRepository;

    // constructores
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // CRUD sobre la entidad laptop

    // Buscar todos los portatiles (lista portatiles)

    /**
     * http://localhost:8080/api/laptops
     * @return
     */
    @GetMapping("api/laptops")
    @ApiOperation("Buscar todos los portátiles")
    public List<Laptop> findAll(){
        // recuperar y devolver los portatiles de la base de datos
        return laptopRepository.findAll();
    }

    /**
     * Buscar un solo portatil en la base de datos según su id
     * Request
     * Response
     * @param id
     * @return
     */

    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Buscar un portatil por clave primaria id Long")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        // opcion 1
        if(laptopOpt.isPresent()){
            return ResponseEntity.ok(laptopOpt.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }

        // opcion 2
        // return laptopOpt.orElse(null);
    }

    /**
     * Crear un nuevo portatil en base de datos
     *
     * @param laptop
     * @return
     */

    @PostMapping("/api/laptops")
    @ApiOperation("Crear un portatil")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        // guardar el libro recibido opr parámetro en la base de datos
        if(laptop.getId() != null){
            log.warn("trying to create a laptop with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result); // el portatil devuelto tiene la clave primaria
    }

    /**
     * Actualizar un portatil existente en la base de datos
     *
     * @param laptop
     * @return
     */

    @PutMapping("/api/laptops")
    @ApiOperation("Actualizar un portatil")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            log.warn("trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("trying to create a laptop with id");
            return ResponseEntity.notFound().build();
        }
        // El proceso de actualización
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    /**
     * Borrar un portatil de la base de datos
     *
     * @param id
     * @return
     */

    @DeleteMapping("/api/laptops/{id}")
    @ApiOperation("Borrar un portatil por clave primaria id Long")
    public ResponseEntity<Laptop> deleteOneById(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("trying to delete a laptop with id");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Borrar todos los portátiles
     *
     * @return
     */

    @DeleteMapping("/api/laptops")
    @ApiOperation("Borrar todos los portátiles")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST request for delete all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
