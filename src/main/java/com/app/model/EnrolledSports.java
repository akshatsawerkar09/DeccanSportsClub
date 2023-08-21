package com.app.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EnrolledSports {

	@Id
	@Column(name = "enrolled_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enrolledId;
	@Column
	private int enrolledStatus;
	@Column
	private double fees;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users userId;
	@ManyToOne
	@JoinColumn(name = "sports_id")
	private Sports sportsId;
	@ManyToOne
	@JoinColumn(name = "batch_id")
	private Batches batchId;
	private LocalDate enrolledTimeStamp;
	private Integer paymentStatus; // 0 paid 1 unpaid

	public EnrolledSports() {
		// TODO Auto-generated constructor stub
	}

	public EnrolledSports(Integer enrolledId, int enrolledStatus, double fees, Users userId, Sports sportsId, Batches batchId,
			LocalDate enrolledTimeStamp, Integer paymentStatus) {
		super();
		this.enrolledId = enrolledId;
		this.enrolledStatus = enrolledStatus;
		this.fees = fees;
		this.userId = userId;
		this.sportsId = sportsId;
		this.batchId = batchId;
		this.enrolledTimeStamp = enrolledTimeStamp;
		this.paymentStatus = paymentStatus;
	}

	public Integer getEnrolledId() {
		return enrolledId;
	}

	public void setEnrolledId(int enrolledId) {
		this.enrolledId = enrolledId;
	}

	public int getEnrolledStatus() {
		return enrolledStatus;
	}

	public void setEnrolledStatus(int enrolledStatus) {
		this.enrolledStatus = enrolledStatus;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public Sports getSportsId() {
		return sportsId;
	}

	public void setSportsId(Sports sportsId) {
		this.sportsId = sportsId;
	}

	public Batches getBatchId() {
		return batchId;
	}

	public void setBatchId(Batches batchId) {
		this.batchId = batchId;
	}

	public LocalDate getEnrolledTimeStamp() {
		return enrolledTimeStamp;
	}

	public void setEnrolledTimeStamp(LocalDate enrolledTimeStamp) {
		this.enrolledTimeStamp = enrolledTimeStamp;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "EnrolledSports [enrolledId=" + enrolledId + ", enrolledStatus=" + enrolledStatus + ", fees=" + fees
				+ ", userId=" + userId + ", sportsId=" + sportsId + ", batchId=" + batchId + ", enrolledTimeStamp="
				+ enrolledTimeStamp + ", paymentStatus=" + paymentStatus + "]";
	}

}
