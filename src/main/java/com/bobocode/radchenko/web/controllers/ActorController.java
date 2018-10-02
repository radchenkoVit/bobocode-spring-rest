package com.bobocode.radchenko.web.controllers;

import com.bobocode.radchenko.entity.Actor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Actor> getAll() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Actor getOne(@PathVariable(name = "id") String id) {
        return new Actor();
    }
}
