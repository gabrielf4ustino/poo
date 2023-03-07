package br.bootcamp.project.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class CourseModel extends ContentModel {

    private Integer workload;

    public CourseModel(String title, String description, Integer workload) {
        this.title = title;
        this.description = description;
        this.workload = workload;
    }

    @Override
    public double calculateXp() {
        return defaultXp += 20d;
    }
}
