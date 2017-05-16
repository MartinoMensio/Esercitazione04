package it.polito.ai.lab4.business.services.images;

import it.polito.ai.lab4.repo.entities.Image;

public interface ImagesService {

	public Image saveNewImage(byte[] image);
	
	public Image getImage(long id);
}
