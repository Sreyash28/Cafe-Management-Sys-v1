package com.cts.cms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.cms.dao.OrdersDaoSpringJdbcImpl;
import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.Orders;

@ExtendWith(MockitoExtension.class)
class OrdersServiceImplTest {

	@Mock
	private OrdersDaoSpringJdbcImpl ordersDaoSpringJdbcImpl;

	@InjectMocks
	private OrdersServiceImpl ordersServiceImpl;

	@Test
	void getAllOrders() throws SystemException {
		LocalDateTime dateTime = LocalDateTime.of(2023, 3, 31, 10, 0, 0);

		List<Orders> order = List.of(new Orders(8, 1, dateTime, "completed"));

		when(ordersDaoSpringJdbcImpl.getAllOrders()).thenReturn(order);
		assertEquals(ordersServiceImpl.getAllOrders().size(), 1);
	}

	@Test
	void testGetOrdersById() throws SystemException {
		LocalDateTime dateTime = LocalDateTime.of(2023, 3, 31, 10, 0, 0);
		Optional<Orders> optional = Optional.of(new Orders(8, 1, dateTime, "completed"));

		when(ordersDaoSpringJdbcImpl.getOrdersById(8)).thenReturn(optional);
		assertEquals(ordersServiceImpl.getOrdersById(8), optional);
	}

}
