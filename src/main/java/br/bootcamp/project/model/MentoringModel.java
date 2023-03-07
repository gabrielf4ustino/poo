package br.bootcamp.project.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class MentoringModel extends ContentModel {

    private LocalDate date;

    public MentoringModel(String title, String description, LocalDate date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    @Override
    public double calculateXp() {
        return defaultXp += 20d;
    }
}
