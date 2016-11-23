package com.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "bookhistory")
public class BookHistory {

	private int id;
	private Book book;
	private Date receiveDate;
	private boolean deliver;

	public BookHistory() {
	}

	public BookHistory(Book book) {
		this.book = book;
	}

	public BookHistory(Book book, Date receiveDate, boolean deliver) {
		super();
		this.book = book;
		this.receiveDate = receiveDate;
		this.deliver = deliver;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public boolean isDeliver() {
		return deliver;
	}

	public void setDeliver(boolean deliver) {
		this.deliver = deliver;
	}

	@Override
	public String toString() {
		return "BookHistory [id=" + id + ", book=" + book + ", receiveDate=" + receiveDate + ", deliver=" + deliver
				+ "]";
	}

	
}
