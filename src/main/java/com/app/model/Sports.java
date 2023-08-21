package com.app.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Sports {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sports_id")
	private Integer sportsId;
	@Column(name = "sports_name")
	private String sportsName;
	@Column(name = "sports_category")
	@Enumerated(EnumType.STRING)
	private SportsCategory sportsCategory;
	@OneToOne
	@JoinColumn(name = "manager_id", unique = true)
	private Users managerId;
	@Column(name = "members_charge")
	private double membersCharge;
	@Column(name = "nonmembers_charge")
	private double nonMembersCharge;

	public Sports() {
		// TODO Auto-generated constructor stub
	}

	public Sports(Integer sportsId, String sportsName, SportsCategory sportsCategory, Users managerId,
			double membersCharge, double nonMembersCharge) {
		super();
		this.sportsId = sportsId;
		this.sportsName = sportsName;
		this.sportsCategory = sportsCategory;
		this.managerId = managerId;
		this.membersCharge = membersCharge;
		this.nonMembersCharge = nonMembersCharge;
	}

	public Integer getSportsId() {
		return sportsId;
	}

	public void setSportsId(Integer sportsId) {
		this.sportsId = sportsId;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public SportsCategory getSportsCategory() {
		return sportsCategory;
	}

	public void setSportsCategory(SportsCategory sportsCategory) {
		this.sportsCategory = sportsCategory;
	}

	public Users getManagerId() {
		return managerId;
	}

	public void setManagerId(Users managerId) {
		this.managerId = managerId;
	}

	public double getMembersCharge() {
		return membersCharge;
	}

	public void setMembersCharge(double membersCharge) {
		this.membersCharge = membersCharge;
	}

	public double getNonMembersCharge() {
		return nonMembersCharge;
	}

	public void setNonMembersCharge(double nonMembersCharge) {
		this.nonMembersCharge = nonMembersCharge;
	}

	@Override
	public String toString() {
		return "Sports [sportsId=" + sportsId + ", sportsName=" + sportsName + ", sportsCategory=" + sportsCategory
				+ ", managerId=" + managerId + ", membersCharge=" + membersCharge + ", nonMembersCharge="
				+ nonMembersCharge + "]";
	}
}
