package com.cts.cms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.cms.dao.OrderItemsDaoSpringJdbcImpl;
import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.OrderItems;

@ExtendWith(MockitoExtension.class)
class OrderItemsServiveImplTest {

	@Mock
	private OrderItemsDaoSpringJdbcImpl orderItemsDaoSpringJdbcImpl;

	@InjectMocks
	private OrderItemsServiceImpl orderItemsServiceImpl;
	
//		1	1	3	30.00
	@Test
	void testGetOrderItemsById() throws SystemException {
		Optional<OrderItems> optional = Optional.of(new OrderItems(8, 1, 3, 30.00));

		when(orderItemsDaoSpringJdbcImpl.getOrderItemById(8)).thenReturn(optional);
		assertEquals(orderItemsServiceImpl.getOrderItemById(8), optional);
	}
}
