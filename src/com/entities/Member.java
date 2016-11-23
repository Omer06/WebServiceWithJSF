package com.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "member")
public class Member {

	private int id;
	private String tc;
	private String name;
	private String surname;
	private String number;
	private Date registerDate;
	private MemberHistory memberHistory = new MemberHistory();
	
	public Member() {}

	public Member(int id) { this.id = id; }

	public Member(String tc, String name, String surname, String number, Date registerDate) {
		super();
		this.tc = tc;
		this.name = name;
		this.surname = surname;
		this.number = number;
		this.registerDate = registerDate;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "history_id")
	public MemberHistory getMemberHistory() {
		return memberHistory;
	}

	public void setMemberHistory(MemberHistory memberHistory) {
		this.memberHistory = memberHistory;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", tc=" + tc + ", name=" + name + ", surname=" + surname + ", number=" + number
				+ ", registerDate=" + registerDate + ", memberHistory=" + memberHistory + "]";
	}

	
}
