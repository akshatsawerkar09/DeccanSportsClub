package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Batches {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "batch_id")
	private Integer batchId;
	@Enumerated(EnumType.STRING)
	private BatchName batchesName;
	@Column
	private String days;
	@Column(name = "coach_name")
	private String coachName;
	private Integer batchStrength;
	@ManyToOne
	@JoinColumn(name = "sports_id")
	private Sports sportsId;
	private double discountOffered;

	public Batches() {
		// TODO Auto-generated constructor stub
	}

	public Batches(Integer batchId, BatchName batchesName, String days, String coachName, Integer batchStrength,
			Sports sportsId, double discountOffered) {
		super();
		this.batchId = batchId;
		this.batchesName = batchesName;
		this.days = days;
		this.coachName = coachName;
		this.batchStrength = batchStrength;
		this.sportsId = sportsId;
		this.discountOffered = discountOffered;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public BatchName getBatchesName() {
		return batchesName;
	}

	public void setBatchesName(BatchName batchesName) {
		this.batchesName = batchesName;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public Integer getBatchStrength() {
		return batchStrength;
	}

	public void setBatchStrength(Integer batchStrength) {
		this.batchStrength = batchStrength;
	}

	public Sports getSportsId() {
		return sportsId;
	}

	public void setSportsId(Sports sportsId) {
		this.sportsId = sportsId;
	}

	public double getDiscountOffered() {
		return discountOffered;
	}

	public void setDiscountOffered(double discountOffered) {
		this.discountOffered = discountOffered;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchesName=" + batchesName + ", days=" + days + ", coachName="
				+ coachName + ", batchStrength=" + batchStrength + ", sportsId=" + sportsId + ", discountOffered="
				+ discountOffered + "]";
	}

}
