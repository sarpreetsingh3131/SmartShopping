package org.store.domain.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "store")
public class Store {
	
	@Id
    @NotBlank
    @Column(name = "id", nullable = false, unique = true)
	private String id;
	
    @NotBlank
    @Column(name = "name", nullable = false)
	private String name;
	
    @NotBlank
    @Column(name = "website", nullable = false)
	private String website;
	
    @NotBlank
    @Column(name = "location", nullable = false)
	private String location;
    
	public Store(){
		
	}

	public Store(String id, String name, String website, String location) {
		this.setId(id);
		this.setName(name);
		this.setWebsite(website);
		this.setLocation(location);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = (id == null) ? this.id : (id.isEmpty() ? this.id : id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = (name == null) ? this.name : (name.isEmpty() ? this.name: name);
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = (website == null) ? this.website : (website.isEmpty() ? this.website: website);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = (location == null) ? this.location : (location.isEmpty() ? this.location: location);
	}	
}