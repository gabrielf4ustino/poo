package br.bootcamp.project.dto;

import br.bootcamp.project.model.ContentModel;
import br.bootcamp.project.model.DevModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class BootcampDTO {

    private String name;

    private String description;

    private Set<ContentModel> contents;

    private Set<DevModel> devs;
}
