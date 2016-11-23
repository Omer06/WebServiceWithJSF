package com.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.NamedQuery;

@NamedQuery(name = "book.getList" , query = "from book")

@XmlRootElement
@Entity(name = "book")
public class Book {

	private int id;
	private String name;
	private String author;
	private int page;
	private Date releaseDate;
	private Category category;
	private List<Member> memberList = new ArrayList<>();
	
	public Book(int id) {
		this.id = id;
	}

	
	public Book() {
	}

	public Book(String name, String author, int page, Date releaseDate , Category category) {
		super();
		this.name = name;
		this.author = author;
		this.page = page;
		this.releaseDate = releaseDate;
		this.category = category;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Temporal(TemporalType.DATE)
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@XmlTransient
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER , targetEntity = Member.class)
	@JoinTable(name = "book_member",
			   joinColumns = @JoinColumn(name = "book_id"),
			   inverseJoinColumns = @JoinColumn(name = "member_id"))
	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", page=" + page + ", releaseDate="
				+ releaseDate + ", category=" + category + "]";
	}

	
}
