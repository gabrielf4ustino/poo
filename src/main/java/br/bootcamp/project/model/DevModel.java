package br.bootcamp.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class DevModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @ToString.Exclude
    private Set<ContentModel> subscribedContents;

    @OneToMany
    @ToString.Exclude
    private Set<ContentModel> finishedContents;

    public DevModel(String name, Set<ContentModel> subscribedContentModels, Set<ContentModel> finishedContentModels) {
        this.name = name;
        this.subscribedContents = subscribedContentModels;
        this.finishedContents = finishedContentModels;
    }
}
