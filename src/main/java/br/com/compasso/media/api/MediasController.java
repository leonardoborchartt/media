package br.com.compasso.media.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.compasso.media.domain.Media;
import br.com.compasso.media.domain.MediaService;
import br.com.compasso.media.domain.dto.MediaDTO;

@RestController
@RequestMapping("/api/v1/medias")
public class MediasController {
	@Autowired
	private MediaService service;

	@GetMapping()
	public ResponseEntity<List<MediaDTO>> get() {

		return ResponseEntity.ok(service.getMedia());
	}

	@GetMapping("/name")
	public ResponseEntity search(@RequestParam("name") String name) {
	    List<MediaDTO> users = service.name(name);
	    return users.isEmpty() ?
	            ResponseEntity.noContent().build() :
	            ResponseEntity.ok(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getId(@PathVariable("id") Long id) {
		Optional<MediaDTO> user = service.getMediaById(id);
		return user.isPresent() ? ResponseEntity.ok(user.get()) : ResponseEntity.notFound().build();

	}
	

	@PostMapping
	public ResponseEntity post(@RequestBody Media media) {
		try {
			MediaDTO u = service.insert(media);
			URI location = getUri(u.getId());
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

	@PutMapping("/{id}")
	public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Media media) {
//		try {
			media.setId(id);
			MediaDTO u = service.update(media, id);
			return u != null ? 
					ResponseEntity.ok(u) :
					ResponseEntity.notFound().build();
			
//		} catch (Exception e) {
//			 return ResponseEntity.badRequest().build();
//		}
		
	
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		boolean ok = service.delete(id);
		return ok ?
				ResponseEntity.ok().build() :
				ResponseEntity.notFound().build();	
	}

}
