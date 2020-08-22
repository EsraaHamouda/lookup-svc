package com.lookup.controller;


import com.lookup.service.BaseService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = "Lookups APIs")
@RestController("/")
@RequestMapping("/lookup")

public class LookupController {

     BaseService baseService;
    /*
    create new entity(POST): localhost:8080/{lookupType}
    body contains the entity
    update entity(PUT): localhost:8080/{lookupType}/uuid
    body contains the entity
    delete entity(DELETE):localhost:8080/{lookupType}/{uuid}
    find entity by id (GET):localhost:8080/{lookupType}/{uuid}
    find all (GET):localhost:8080/{lookupType}*/


    @GetMapping("/list/{type}")
    public ResponseEntity<Object> route(@PathVariable String type) {

        baseService = LookupFactory.getService(type);
        if (baseService == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        List result = baseService.findAll();
        if (result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/{type}")
    public ResponseEntity<Object> create(@RequestBody Object entity, @PathVariable String type) {
        baseService = LookupFactory.getService(type);
        assert baseService != null;
        baseService.create(entity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping("/{type}/{uuid}")
    public ResponseEntity<Object> update(@RequestBody Object entity, @PathVariable("uuid") String entityId,
                                         @PathVariable("type") String type) {
        baseService = LookupFactory.getService(type);

        if (baseService != null) {
            baseService.update(entity);
        }

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/{type}/{uuid}")
    public ResponseEntity<String> deleteCategory(@PathVariable("uuid") String uuid,
                                                 @PathVariable("type") String type) {

        baseService = LookupFactory.getService(type);

        if (baseService != null) {
            baseService.deleteById(uuid);
        }

        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }


    @GetMapping("/{type}/{uuid}")
    public ResponseEntity<Object> findById(@PathVariable("uuid") String uuid,
                                           @PathVariable("type") String type) {
        baseService = LookupFactory.getService(type);

        if (baseService != null) {
            Optional entity = baseService.findById(uuid);
            return (ResponseEntity<Object>) entity.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                    orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }


}