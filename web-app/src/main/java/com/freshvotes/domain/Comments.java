package com.freshvotes.domain;

import javax.persistence.*;

@Embeddable
@Entity
public class Comments {
	private CommentId pk;
	@EmbeddedId
	public CommentId getPk() {
		return pk;
	}
	public void setPk(CommentId pk) {
		this.pk = pk;
	}
	
	@Column(length = 500)
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	private String text;
	
}
