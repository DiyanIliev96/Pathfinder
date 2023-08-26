package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
public class Category extends BaseEntity{
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;
}
