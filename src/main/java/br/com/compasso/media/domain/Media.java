package br.com.compasso.media.domain;



import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import lombok.Data;


@Entity
@Data
public class Media {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String latitude;
	private String longitude;
	private LocalDate createDate;
	private LocalDate uploadDate;
	private LocalDate publicationDate;
}
