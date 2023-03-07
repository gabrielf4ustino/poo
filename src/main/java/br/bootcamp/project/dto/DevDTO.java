package br.bootcamp.project.dto;

import br.bootcamp.project.model.ContentModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class DevDTO {

    private String name;

    private Set<ContentModel> subscribedContentModels;

    private Set<ContentModel> finishedContentModels;
}
