package com.sap.rroggia.bookstore;

import com.sap.rroggia.bookstore.db.BookTable;
import com.sap.rroggia.bookstore.db.Database;

public class Library {

	private Database db;
	private static final String BOOK_TABLE = "Book";

	public Library(Database db) {
		this.db = db;
	}

	public void addBookToLibrary(Book book) {

		if (isInvalidBook(book))
			throw new IllegalArgumentException("Invalid Book.");

		if (hasBook(book))
			throw new IllegalArgumentException("Book already exists.");

		BookTable booksTable = db.getTable(BOOK_TABLE);
		booksTable.persist(book);
	}

	public boolean hasBook(Book book) {
		BookTable booksTable = db.getTable(BOOK_TABLE);
		return booksTable.select(book.getName()) != null ? true : false;
	}

	private boolean isInvalidBook(Book book) {
		return book == null || book.getName() == null || book.getName().isEmpty();

	}

}
