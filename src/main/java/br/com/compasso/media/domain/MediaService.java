package br.com.compasso.media.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.compasso.media.domain.dto.MediaDTO;

@Service
public class MediaService {

	@Autowired
	private MediaRepository rep;

	public List<MediaDTO> getMedia() {
		return rep.findAll().stream().map(MediaDTO::create).collect(Collectors.toList());
	}

	public Optional<MediaDTO> getMediaById(Long id) {
		return rep.findById(id).map(MediaDTO::create);
	}

	public Iterable<Media> getMediaByName(String name) {
		return rep.findByName(name);
	}

	public MediaDTO insert(Media media) {
		Assert.isNull(media.getId(), "não foi possivel atualizar o registro");
		return MediaDTO.create(rep.save(media));
	}

	public MediaDTO update(Media media, Long id) {
		Assert.notNull(id, "Não foi possivel atualizar");

		Optional<Media> optional = rep.findById(id);
		if (optional.isPresent()) {
			Media db = optional.get();
			db.setName(media.getName());
			db.setDescription(media.getDescription());
			db.setLatitude(media.getLatitude());
			db.setLongitude(media.getLatitude());
			db.setCreateDate(media.getCreateDate());
			db.setUploadDate(media.getUploadDate());
			db.setPublicationDate(media.getPublicationDate());
			

			System.out.println("Media id " + db.getId());
			rep.save(db);
			return MediaDTO.create(db);
		} else {
			throw new RuntimeException("Não foi possivel registro");
		}

	}

	public boolean delete(Long id) {
		if (getMediaById(id).isPresent()) {
			rep.deleteById(id);
			return true;
		}
		return false;
	}

	public List<MediaDTO> name(String name) {
		return rep.findByName(name).stream().map(MediaDTO::create).collect(Collectors.toList());
	}
}
