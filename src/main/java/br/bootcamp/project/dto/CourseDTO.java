package br.bootcamp.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDTO {

    private String title;

    private String description;

    private Integer workload;
}
