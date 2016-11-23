package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "category")
public class Category {

	private int id;
	private String name;
	private List<Book> bookList = new ArrayList<Book>();

	public Category() {
	}

	public Category(int id) {
		this.id = id;
	}

	public Category(String name) {
		this.name = name;
	}

	@GeneratedValue
	@Id
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

	@Transient
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", bookList=" + bookList + "]";
	}

}
