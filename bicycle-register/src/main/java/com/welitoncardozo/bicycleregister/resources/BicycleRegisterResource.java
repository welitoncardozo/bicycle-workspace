package com.welitoncardozo.bicycleregister.resources;

import com.welitoncardozo.bicycleregister.dto.BicycleDto;
import com.welitoncardozo.bicycleregister.service.BicycleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping
public class BicycleRegisterResource {
    private final BicycleService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BicycleDto dto) {
        service.save(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/aluga/{id}")
    public ResponseEntity<?> aluga(@PathVariable Long id) {
        service.rent(id, true);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/devolve/{id}")
    public ResponseEntity<?> devolve(@PathVariable Long id) {
        service.rent(id, false);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
