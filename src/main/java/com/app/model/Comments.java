package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comments_id")
	private int commentId;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users userId;

	@ManyToOne
	@JoinColumn(name = "batch_id")
	private Batches batchId;
	@Column
	private String comment;

	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public Comments(int commentId, Users userId, Batches batchId, String comment) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.batchId = batchId;
		this.comment = comment;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public Batches getBatchId() {
		return batchId;
	}

	public void setBatchId(Batches batchId) {
		this.batchId = batchId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", batchId=" + batchId + ", comment="
				+ comment + "]";
	}

}
