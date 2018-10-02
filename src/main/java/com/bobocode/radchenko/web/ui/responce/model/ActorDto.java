package com.bobocode.radchenko.web.ui.responce.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActorDto {
    private Long id;
    public String firstName;
    public String lastName;
}
