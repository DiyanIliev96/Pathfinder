package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.LevelEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "routes")
@NoArgsConstructor
@Getter
@Setter
public class Route extends BaseEntity {
    @Lob
    @Column(name = "gpx_coordinates",columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Enumerated(EnumType.STRING)
    private LevelEnum level;
    @Column(nullable = false,unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "video_url")
    private String videoUrl;
    @ManyToOne(fetch = FetchType.EAGER)
    private User author;
    @ManyToMany
    private Set<Category> categories;
    @OneToMany(mappedBy = "route")
    private Set<Comment> comments;
    @OneToMany(mappedBy = "route",fetch = FetchType.EAGER)
    private Set<Picture> pictures;
}
