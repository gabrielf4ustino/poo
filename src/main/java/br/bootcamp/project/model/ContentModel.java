package br.bootcamp.project.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "ContentModel")
public abstract class ContentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String title;

    protected String description;

    protected static double defaultXp = 10d;

    public abstract double calculateXp();
}
