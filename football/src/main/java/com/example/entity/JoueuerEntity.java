package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="joueur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JoueuerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_joueur") // Map to the correct column name in your database
    private Long idJoueur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "poste")
    private String poste;
    
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private EquipeEntity equipe;


  
}
