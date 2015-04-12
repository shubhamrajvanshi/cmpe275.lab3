package edu.sjsu.cmpe275.model;

import java.util.List;

public class Player {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String description;
    private Address address;
    private Sponsor sponsor;
    private List<Player> opponents;
    
    /**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the sponsor
	 */
	public Sponsor getSponsor() {
		return sponsor;
	}
	/**
	 * @param sponsor the sponsor to set
	 */
	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	/**
	 * @return the opponents
	 */
	public List<Player> getOpponents() {
		return opponents;
	}
	/**
	 * @param opponents the opponents to set
	 */
	public void setOpponents(List<Player> opponents) {
		this.opponents = opponents;
	}
	
}
