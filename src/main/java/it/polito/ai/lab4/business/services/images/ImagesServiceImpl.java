package it.polito.ai.lab4.business.services.images;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.polito.ai.lab4.repo.ImagesRepository;
import it.polito.ai.lab4.repo.entities.Image;

@Service
@Transactional
public class ImagesServiceImpl implements ImagesService{

	@Autowired
	private ImagesRepository imagesRepository;
	
	@Override
	public Image saveNewImage(byte[] imageBytes) {
		Image image = new Image(imageBytes);
		return imagesRepository.save(image);
	}

	@Override
	public Image getImage(long id) {
		return imagesRepository.findOne(id);
	}

}
