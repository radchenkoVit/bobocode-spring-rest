package com.bobocode.radchenko.web.controllers;

import com.bobocode.radchenko.entity.Actor;
import com.bobocode.radchenko.service.ActorService;
import com.bobocode.radchenko.web.ui.responce.model.ActorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ActorDto> getAll() {
        List<Actor> actorsEntity = actorService.findAll();
        return actorsEntity.stream().map(this::toActorDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ActorDto getOne(@PathVariable(name = "id") Long id) {
        return toActorDto(actorService.findById(id));
    }

    private ActorDto toActorDto(Actor actor) {
        return ActorDto.builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .build();
    }
}
