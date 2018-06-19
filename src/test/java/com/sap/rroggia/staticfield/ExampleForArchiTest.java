package com.sap.rroggia.staticfield;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class ExampleForArchiTest {

	@Test
	public void mocking() {
		DummyClass mock = mock(DummyClass.class);
		doNothing().when(mock).doSomething();

		ExampleForArchi.dummy = mock;
		ExampleForArchi.doSomething();

		assertTrue(true);
	}

}
