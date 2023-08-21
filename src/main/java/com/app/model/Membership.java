package com.app.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Membership {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "membership_id")
	private int membershipId;
	@Enumerated(EnumType.STRING)
	private MemberShipType membershipType;
	@Column(name = "reg_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate regDate;
	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	@Column
	private double costPaid;
	@OneToOne
	@JoinColumn(name = "user_id")
	private Users userId;

	public Membership() {
		// TODO Auto-generated constructor stub
	}

	public Membership(int membershipId, MemberShipType membershipType, LocalDate regDate, LocalDate endDate,
			double costPaid, Users userId) {
		super();
		this.membershipId = membershipId;
		this.membershipType = membershipType;
		this.regDate = regDate;
		this.endDate = endDate;
		this.costPaid = costPaid;
		this.userId = userId;
	}

	public int getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(int membershipId) {
		this.membershipId = membershipId;
	}

	public MemberShipType getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(MemberShipType membershipType) {
		this.membershipType = membershipType;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getCostPaid() {
		return costPaid;
	}

	public void setCostPaid(double costPaid) {
		this.costPaid = costPaid;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Membership [membershipId=" + membershipId + ", membershipType=" + membershipType + ", regDate="
				+ regDate + ", endDate=" + endDate + ", costPaid=" + costPaid + ", userId=" + userId + "]";
	}

}
