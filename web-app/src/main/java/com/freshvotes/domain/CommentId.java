package com.freshvotes.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
@Embeddable
public class CommentId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7733599307368006946L;
	private Users users;
	private Features features;
	@ManyToOne
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	@ManyToOne
	public Features getFeatures() {
		return features;
	}
	public void setFeatures(Features features) {
		this.features = features;
	}

}
