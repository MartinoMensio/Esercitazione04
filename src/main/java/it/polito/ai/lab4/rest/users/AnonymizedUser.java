package it.polito.ai.lab4.rest.users;

import java.util.Date;

import org.springframework.hateoas.Identifiable;

import it.polito.ai.lab4.repo.entities.CarSharingService;
import it.polito.ai.lab4.repo.entities.EducationLevel;
import it.polito.ai.lab4.repo.entities.Employment;
import it.polito.ai.lab4.repo.entities.Fuel;
import it.polito.ai.lab4.repo.entities.TravelDocument;
import it.polito.ai.lab4.repo.entities.User;
import it.polito.ai.lab4.repo.entities.UserProfile;

public class AnonymizedUser implements Identifiable<Long> {

	private Long id;

	private String sex;
	private Date dateOfBirth;
	private EducationLevel educationLevel;
	private Employment employment;

	private Boolean privateCarOwnership;
	private Integer carRegistrationYear;
	private Fuel carFuel;

	private Boolean carSharingUsage;
	private CarSharingService carSharingService;

	private Boolean bikeUsage;
	private Boolean privateBikeUsage;
	private Boolean bikeSharingUsage;

	private Boolean publicTransportUsage;
	private TravelDocument habitualTravelDocument;

	/**
	 * build an anonymized user from a user
	 * 
	 * @param user
	 */
	public AnonymizedUser(User user) {
		this.id = user.getId();
		UserProfile userProfile = user.getProfile();
		if(userProfile != null){
		this.dateOfBirth = userProfile.getDateOfBirth();
		this.educationLevel = userProfile.getEducationLevel();
		this.employment = userProfile.getEmployment();
		this.privateCarOwnership = userProfile.getPrivateCarOwnership();
		this.carRegistrationYear = userProfile.getCarRegistrationYear();
		this.carFuel = userProfile.getCarFuel();
		this.carSharingUsage = userProfile.getCarSharingUsage();
		this.carSharingService = userProfile.getCarSharingService();
		this.bikeUsage = userProfile.getBikeUsage();
		this.privateBikeUsage = userProfile.getPrivateBikeUsage();
		this.bikeSharingUsage = userProfile.getBikeSharingUsage();
		this.publicTransportUsage = userProfile.getPublicTransportUsage();
		this.habitualTravelDocument = userProfile.getHabitualTravelDocument();
		}
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getSex() {
		return sex;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public EducationLevel getEducationLevel() {
		return educationLevel;
	}

	public Employment getEmployment() {
		return employment;
	}

	public Boolean getPrivateCarOwnership() {
		return privateCarOwnership;
	}

	public Integer getCarRegistrationYear() {
		return carRegistrationYear;
	}

	public Fuel getCarFuel() {
		return carFuel;
	}

	public Boolean getCarSharingUsage() {
		return carSharingUsage;
	}

	public CarSharingService getCarSharingService() {
		return carSharingService;
	}

	public Boolean getBikeUsage() {
		return bikeUsage;
	}

	public Boolean getPrivateBikeUsage() {
		return privateBikeUsage;
	}

	public Boolean getBikeSharingUsage() {
		return bikeSharingUsage;
	}

	public Boolean getPublicTransportUsage() {
		return publicTransportUsage;
	}

	public TravelDocument getHabitualTravelDocument() {
		return habitualTravelDocument;
	}

}
