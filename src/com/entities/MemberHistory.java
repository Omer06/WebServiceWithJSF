package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "memberhistory")
public class MemberHistory {

	private int id;
	List<BookHistory> bookList = new ArrayList<>();

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "history_id")
	public List<BookHistory> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookHistory> bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "MemberHistory [id=" + id + ", bookList=" + bookList + "]";
	}
	
	

}
