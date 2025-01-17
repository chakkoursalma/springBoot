package com.example.entity;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipe")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipeEntity {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  
	  @Column(name = "idEquipe")
	  private Long id;

	  @Column(name = "nomEquipe")
	  @JsonInclude(JsonInclude.Include.NON_NULL)
	  private String nomEquipe;

	  @Column(name = "pays")
	  @JsonInclude(JsonInclude.Include.NON_NULL)
	  private String pays;

	 // @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL)
	 // @JsonIgnore
	 //private List<JoueuerEntity> joueuers; 
}
