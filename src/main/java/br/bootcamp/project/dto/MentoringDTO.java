package br.bootcamp.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MentoringDTO {

    private String title;

    private String description;

    private LocalDate date;
}
