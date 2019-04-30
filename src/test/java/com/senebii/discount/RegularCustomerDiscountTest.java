package com.senebii.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.senebii.customer.Customer;
import com.senebii.order.Order;
import com.senebii.order.OrderProduct;
import com.senebii.product.Product;
import com.senebii.product.ProductType;

class RegularCustomerDiscountTest {
	
	
	@Test
	@DisplayName("Validate discount for customer with over 2 years joining date")
	public void testRegularDiscount_over2yearsJoiningDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 3);
		Date joindate = calendar.getTime();
		
		validateDiscount(joindate, 100, 5);
	}
	
	@Test
	@DisplayName("Validate discount for customer with over 2 years joining date")
	public void testRegularDiscount_lessThan2YearsJoiningDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 1);
		Date joindate = calendar.getTime();
		
		validateDiscount(joindate, 100, 0);
	}
	
	private void validateDiscount(Date joinDate, double productPrice, double expected) {
		DiscountStrategy discountStrategy = createDiscountStrategy(joinDate);
		
		Order order = new Order(1, new Customer(1, new Date()));
		Product product = new Product(1, 100, ProductType.OTHER);
		order.addOrderProduct(new OrderProduct(1, order, product));
		double discount = discountStrategy.calculateDiscount(order);
		assertEquals(expected, discount);
	}
	

	private DiscountStrategy createDiscountStrategy(Date joinDate) {
		return new RegularCustomerDiscount(new Customer(1, joinDate));
	}
	
}
