package com.sap.rroggia.bookstore;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.sap.rroggia.bookstore.db.BookTable;
import com.sap.rroggia.bookstore.db.Database;

public class LibraryTest {

	@Test
	public void shouldGetTheRightTable() {

		Database mockDB = mock(Database.class);

		new Library(mockDB);

		verify(mockDB).getTable("Book");

	}

	@Test
	public void shouldReturnFalseIfDontHaveBook() {

		Book book = new Book("Test");

		BookTable booksTable = mock(BookTable.class);
		when(booksTable.select(anyString())).thenReturn(null);

		Database mockDB = mock(Database.class);
		when(mockDB.getTable(anyString())).thenReturn(booksTable);

		assertFalse(new Library(mockDB).hasBook(book));

	}

	@Test
	public void shouldReturnTrueIfLIbraryHasTheBook() {

		Book book = new Book("Test");

		BookTable booksTable = mock(BookTable.class);
		when(booksTable.select(anyString())).thenReturn(book);

		Database mockDB = mock(Database.class);
		when(mockDB.getTable(anyString())).thenReturn(booksTable);

		assertTrue(new Library(mockDB).hasBook(book));

	}

	@Test
	public void shouldThrowExceptionOnPersist() {
		Book book = new Book("Test");

		BookTable booksTable = mock(BookTable.class);
		when(booksTable.select(anyString())).thenReturn(null);
		doThrow(new IllegalStateException("Lost db connection")).when(booksTable).persist(book);

		Database mockDB = mock(Database.class);
		when(mockDB.getTable(anyString())).thenReturn(booksTable);

		try {
			new Library(mockDB).addBookToLibrary(book);
			fail();
		} catch (IllegalStateException e) {
			assertThat(e.getMessage(), equalTo("Lost db connection"));
		}
	}

}
