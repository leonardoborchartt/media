package br.com.compasso.media.domain.dto;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import br.com.compasso.media.domain.Media;
import lombok.Data;

@Data
public class MediaDTO {

	private Long id;
	private String name;
	private String description;
	private String latitude;
	private String longitude;
	private LocalDate createDate;
	private LocalDate uploadDate;
	private LocalDate publicationDate;
	
	
	
	
	public static MediaDTO create(Media u) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(u, MediaDTO.class);
	}

}

