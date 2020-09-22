package com.freshvotes.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class Votes {
	
	
	private VoteId pk;
	
	@EmbeddedId
	public VoteId getPk() {
		return pk;
	}

	public void setPk(VoteId pk) {
		this.pk = pk;
	}

	private boolean upvote;
	
	public boolean isUpvote() {
		return upvote;
	}

	public void setUpvote(boolean upvote) {
		this.upvote = upvote;
	}



}
