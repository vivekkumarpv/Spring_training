package com.ust.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppTest {

	@Mock
	AppService service;

	@InjectMocks
	App app;

	@Test
	void testCheck() {
		when(service.checkEven(10)).thenReturn(true);
		when(service.checkEven(5)).thenReturn(false);
		assertTrue(app.check(10));
		assertFalse(app.check(5));
		verify(service,times(1)).checkEven(10);
		verify(service,times(1)).checkEven(5);
		String str="abc";
		when(service.findStringLength(str)).thenReturn(3);
		assertEquals(service.findStringLength(str), 3);
	}

}
