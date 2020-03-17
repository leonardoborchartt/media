package br.com.compasso.media.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MediaRepository extends JpaRepository<Media, Long>{

	List<Media> findByName(String name);

	
}
