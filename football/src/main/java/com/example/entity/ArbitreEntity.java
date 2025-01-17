package com.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "arbitre")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArbitreEntity {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "idArbitre")
	  private Long id;

	  @Column(name = "nom")
	  @JsonInclude(JsonInclude.Include.NON_NULL)
	  private String nom;

	 @Column(name = "nationalite")
	 @JsonInclude(JsonInclude.Include.NON_NULL)
	 private String nationalite;
}
