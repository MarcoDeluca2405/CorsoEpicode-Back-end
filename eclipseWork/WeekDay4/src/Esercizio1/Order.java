package Esercizio1;

import java.time.LocalDate;
import java.util.List;

public class Order {
private long id;
private String status;
private LocalDate orderDate;
private LocalDate deliveryDate;
private List<Product> products;
private Customer customer;

public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products,
		Customer customer) {
	super();
	this.id = id;
	this.status = status;
	this.orderDate = orderDate;
	this.deliveryDate = deliveryDate;
	this.products = products;
	this.customer = customer;
}



public Order(long id, List<Product> products, Customer customer) {
	super();
	this.id = id;
	this.products = products;
	this.customer = customer;
}



public Order(long id, String status, List<Product> products) {
	super();
	this.id = id;
	this.status = status;
	this.products = products;
}



/**
 * @return the id
 */
public long getId() {
	return id;
}


/**
 * @param id the id to set
 */
public void setId(long id) {
	this.id = id;
}


/**
 * @return the status
 */
public String getStatus() {
	return status;
}


/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}


/**
 * @return the orderDate
 */
public LocalDate getOrderDate() {
	return orderDate;
}


/**
 * @param orderDate the orderDate to set
 */
public void setOrderDate(LocalDate orderDate) {
	this.orderDate = orderDate;
}


/**
 * @return the deliveryDate
 */
public LocalDate getDeliveryDate() {
	return deliveryDate;
}


/**
 * @param deliveryDate the deliveryDate to set
 */
public void setDeliveryDate(LocalDate deliveryDate) {
	this.deliveryDate = deliveryDate;
}


/**
 * @return the products
 */
public Product getProducts() {
	return (Product) products;
}


/**
 * @param products the products to set
 */
public void setProducts(List<Product> products) {
	this.products = products;
}


/**
 * @return the customer
 */
public Customer getCustomer() {
	return customer;
}


/**
 * @param customer the customer to set
 */
public void setCustomer(Customer customer) {
	this.customer = customer;
}




}
