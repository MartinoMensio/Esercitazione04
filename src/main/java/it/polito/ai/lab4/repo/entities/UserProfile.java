package it.polito.ai.lab4.repo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Type;

@Entity(name="userProfiles")
public class UserProfile {
	@Id
	private long id;
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	private String sex;
	@Type(type="date")
	private Date dateOfBirth;
	@ManyToOne
	@JoinColumn(name="education_level_id")
	private EducationLevel educationLevel;
	@ManyToOne
	@JoinColumn(name="employment_id")
	private Employment employment;
	
	private boolean privateCarOwnership;
	private int carRegistrationYear;
	@ManyToOne
	@JoinColumn(name="fuel_id")
	private Fuel carFuel;
	
	private boolean carSharingUsage;
	@ManyToOne
	@JoinColumn(name="car_sharing_service_id")
	private CarSharingService carSharingService;
	
	private boolean bikeUsage;
	private boolean privateBikeUsage;
	private boolean bikeSharingUsage;
	
	private boolean publicTransportUsage;
	@ManyToOne
	@JoinColumn(name="habitual_travel_document_id")
	private TravelDocument habitualTravelDocument;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public boolean getPrivateCarOwnership() {
		return privateCarOwnership;
	}
	public void setPrivateCarOwnership(boolean privateCarOwnership) {
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
	public boolean getCarSharingUsage() {
		return carSharingUsage;
	}
	public void setCarSharingUsage(boolean carSharingUsage) {
		this.carSharingUsage = carSharingUsage;
	}
	public CarSharingService getCarSharingService() {
		return carSharingService;
	}
	public void setCarSharingService(CarSharingService carSharingService) {
		this.carSharingService = carSharingService;
	}
	public boolean getBikeUsage() {
		return bikeUsage;
	}
	public void setBikeUsage(boolean bikeUsage) {
		this.bikeUsage = bikeUsage;
	}
	public boolean getPrivateBikeUsage() {
		return privateBikeUsage;
	}
	public void setPrivateBikeUsage(boolean privateBikeUsage) {
		this.privateBikeUsage = privateBikeUsage;
	}
	public boolean getBikeSharingUsage() {
		return bikeSharingUsage;
	}
	public void setBikeSharingUsage(boolean bikeSharingUsage) {
		this.bikeSharingUsage = bikeSharingUsage;
	}
	public boolean isPublicTransportUsage() {
		return publicTransportUsage;
	}
	public void setPublicTransportUsage(boolean publicTransportUsage) {
		this.publicTransportUsage = publicTransportUsage;
	}
	public TravelDocument getHabitualTravelDocument() {
		return habitualTravelDocument;
	}
	public void setHabitualTravelDocument(TravelDocument habitualTravelDocument) {
		this.habitualTravelDocument = habitualTravelDocument;
	}
}
