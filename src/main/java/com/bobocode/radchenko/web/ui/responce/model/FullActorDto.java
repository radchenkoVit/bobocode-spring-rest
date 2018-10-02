package com.bobocode.radchenko.web.ui.responce.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

//TODO: delete, just experiment
@Data
@Builder
public class FullActorDto {
    private Long id;
    public String firstName;
    public String lastName;
    public Set<MovieDto> movies;
}
