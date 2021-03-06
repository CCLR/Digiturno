package edu.konrad.digiturno.dao;

import java.util.List;

import edu.konrad.digiturno.model.MyCustomer;

public interface CustomerDao {

	MyCustomer findById(long id);

	MyCustomer findByName(String name);

	void saveCustomer(MyCustomer Customer);

	void updateCustomer(MyCustomer Customer);

	void deleteCustomerById(long id);

	List<MyCustomer> findAllCustomers();

	void deleteAllCustomers();

	boolean isCustomerExist(MyCustomer Customer);
}
