package com.bobocode.radchenko.web.ui.responce.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDto {
    private Long id;
    private String name;
}
