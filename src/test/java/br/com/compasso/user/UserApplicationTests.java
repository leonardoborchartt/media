package br.com.compasso.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.compasso.media.domain.Media;
import br.com.compasso.media.domain.MediaService;
import br.com.compasso.media.domain.dto.MediaDTO;

import static junit.framework.TestCase.*;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class UserApplicationTests {

	@Autowired
	private MediaService service;
	
	@Test
	public void testeSave() {
		Media media = new Media();
		media.setName("foto1");
		media.setDescription("ilha");
		MediaDTO u = service.insert(media);
		
		assertNotNull(u);
		Long id = u.getId();
		assertNotNull(id);
		//buscar o objeto
		Optional<MediaDTO> op = service.getMediaById(id);
		assertTrue(op.isPresent());
		
		u = op.get();
		assertEquals("joao", u.getName());
		assertEquals("joao@hotmail.com", u.getEmail());
		assertEquals("jo", u.getUsername());
		
		//deleta o usuario
		service.delete(id);
		
		///verifica se deletou
		assertFalse(service.getMediaById(id).isPresent());		
		
	}
	
	@Test
	public void testLista() {
		List<MediaDTO> users = service.getMedia();
		assertEquals(7, users.size());
	}
	
	
	@Test
	public void testGet() {
		Optional<MediaDTO> op = service.getMediaById(3L);
		assertTrue(op.isPresent());
		MediaDTO c = op.get();
		assertEquals("Media", c.getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
}
