package com.example.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "matches")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "idMatch")
	private Long id;
	
	@Column(name = "dateMatch")
	private LocalDate dateMatch;

	@Column(name = "heureMatch")
	private LocalTime heureMatch;
	
	@Column(name = "lieu")
	private String lieu;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "stadeId")
	private StadeEntity stade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "arbitreId")
	private ArbitreEntity arbitre;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipeOne")
    private EquipeEntity equipeOne;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipeTwo")
    private EquipeEntity equipeTwo;

}

