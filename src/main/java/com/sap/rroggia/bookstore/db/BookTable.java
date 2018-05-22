package com.sap.rroggia.bookstore.db;

import com.sap.rroggia.bookstore.Book;

public class BookTable {

	public Book select(String name) {
		throw new RuntimeException("You cannot rely on database connection");
	}

	public void persist(Book book) {
		throw new RuntimeException("You cannot rely on database connection");

	}

}
