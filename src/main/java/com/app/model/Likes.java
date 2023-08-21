package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "likes_table")
public class Likes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "like_id")
	private int likeId;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users userId;

	@ManyToOne
	@JoinColumn(name = "batch_id")
	private Batches batchId;

	public Likes() {
		// TODO Auto-generated constructor stub
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
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

	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", userId=" + userId + ", batchId=" + batchId + "]";
	}

}
