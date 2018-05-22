package com.sap.rroggia.bookstore;

import com.sap.rroggia.bookstore.db.BookTable;
import com.sap.rroggia.bookstore.db.Database;

public class Library {

	private BookTable booksTable;
	private static final String BOOK_TABLE = "Book";

	public Library(Database db) {
		this.booksTable = db.getTable(BOOK_TABLE);
	}

	public void addBookToLibrary(Book book) {

		if (isInvalidBook(book))
			throw new IllegalArgumentException("Invalid Book.");

		if (hasBook(book))
			throw new IllegalArgumentException("Book already exists.");

		booksTable.persist(book);
	}

	public boolean hasBook(Book book) {
		return booksTable.select(book.getName()) != null ? true : false;
	}

	private boolean isInvalidBook(Book book) {
		return book == null || book.getName() == null || book.getName().isEmpty();

	}

}
