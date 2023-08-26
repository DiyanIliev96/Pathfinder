package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.enums.RoleEnums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role extends BaseEntity{
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnums name;
}
