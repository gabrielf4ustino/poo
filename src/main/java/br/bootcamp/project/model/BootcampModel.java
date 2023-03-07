package br.bootcamp.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class BootcampModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private final LocalDate initialDate = LocalDate.now();

    private final LocalDate finalDate = initialDate.plusDays(45);

    @OneToMany
    @ToString.Exclude
    private Set<ContentModel> contents;

    @OneToMany
    @ToString.Exclude
    private Set<DevModel> devs;

    public BootcampModel(String name, String description, Set<ContentModel> contents, Set<DevModel> devs) {
        this.name = name;
        this.description = description;
        this.contents = contents;
        this.devs = devs;
    }
}
