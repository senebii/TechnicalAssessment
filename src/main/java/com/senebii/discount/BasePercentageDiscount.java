package com.senebii.discount;

import java.util.List;
import java.util.stream.Collectors;

import com.senebii.order.Order;
import com.senebii.order.OrderProduct;
import com.senebii.product.ProductType;

public abstract class BasePercentageDiscount implements DiscountStrategy{

	@Override
	public double calculateDiscount(Order order) {
		List<OrderProduct> nonGroceryItems = order.getOrderProducts().stream()
												  .filter(op -> op.getProduct().getProductType() != ProductType.GROCERY)
												  .collect(Collectors.toList());
		
		double total = nonGroceryItems.stream()
									   .map( op -> op.getProduct().getPrice() * op.getQuantity() )
									   .reduce( (a, b) -> a + b )
									   .orElse(0.0);
		
		return calculateNonGroceryItemsDiscount(total);
	}
	
	public abstract double calculateNonGroceryItemsDiscount(double total);
	
}
