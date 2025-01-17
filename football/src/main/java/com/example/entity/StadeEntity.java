package com.example.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "stade")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StadeEntity {
    @Id
    @Column(name = "idStade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomStade")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nomStade;

    @Column(name = "capacite")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int capacite;
}
