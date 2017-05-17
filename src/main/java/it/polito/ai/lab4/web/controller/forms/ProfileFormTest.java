package it.polito.ai.lab4.web.controller.forms;

import java.util.Date;

import it.polito.ai.lab4.repo.entities.CarSharingService;
import it.polito.ai.lab4.repo.entities.EducationLevel;
import it.polito.ai.lab4.repo.entities.Employment;
import it.polito.ai.lab4.repo.entities.Fuel;
import it.polito.ai.lab4.repo.entities.TravelDocument;
import it.polito.ai.lab4.repo.entities.UserProfile;

public class ProfileFormTest {
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
	
	
	public ProfileFormTest() {
	}
	
	public ProfileFormTest(UserProfile userProfile) {
		this.sex = userProfile.getSex();
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
                                                                              
		this.publicTransportUsage = isPublicTransportUsage();
		this.habitualTravelDocument = getHabitualTravelDocument();
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public EducationLevel getEducationLevel() {
		return educationLevel;
	}
	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
	}
	public Employment getEmployment() {
		return employment;
	}
	public void setEmployment(Employment employment) {
		this.employment = employment;
	}
	public Boolean getPrivateCarOwnership() {
		return privateCarOwnership;
	}
	public void setPrivateCarOwnership(Boolean privateCarOwnership) {
		this.privateCarOwnership = privateCarOwnership;
	}
	public int getCarRegistrationYear() {
		return carRegistrationYear;
	}
	public void setCarRegistrationYear(int carRegistrationYear) {
		this.carRegistrationYear = carRegistrationYear;
	}
	public Fuel getCarFuel() {
		return carFuel;
	}
	public void setCarFuel(Fuel carFuel) {
		this.carFuel = carFuel;
	}
	public Boolean getCarSharingUsage() {
		return carSharingUsage;
	}
	public void setCarSharingUsage(Boolean carSharingUsage) {
		this.carSharingUsage = carSharingUsage;
	}
	public CarSharingService getCarSharingService() {
		return carSharingService;
	}
	public void setCarSharingService(CarSharingService carSharingService) {
		this.carSharingService = carSharingService;
	}
	public Boolean getBikeUsage() {
		return bikeUsage;
	}
	public void setBikeUsage(Boolean bikeUsage) {
		this.bikeUsage = bikeUsage;
	}
	public Boolean getPrivateBikeUsage() {
		return privateBikeUsage;
	}
	public void setPrivateBikeUsage(Boolean privateBikeUsage) {
		this.privateBikeUsage = privateBikeUsage;
	}
	public Boolean getBikeSharingUsage() {
		return bikeSharingUsage;
	}
	public void setBikeSharingUsage(Boolean bikeSharingUsage) {
		this.bikeSharingUsage = bikeSharingUsage;
	}
	public Boolean isPublicTransportUsage() {
		return publicTransportUsage;
	}
	public void setPublicTransportUsage(Boolean publicTransportUsage) {
		this.publicTransportUsage = publicTransportUsage;
	}
	public TravelDocument getHabitualTravelDocument() {
		return habitualTravelDocument;
	}
	public void setHabitualTravelDocument(TravelDocument habitualTravelDocument) {
		this.habitualTravelDocument = habitualTravelDocument;
	}
}
