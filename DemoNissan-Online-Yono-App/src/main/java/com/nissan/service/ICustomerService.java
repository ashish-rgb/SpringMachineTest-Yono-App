package com.nissan.service;

import java.util.List;

import com.nissan.model.Customer;

public interface ICustomerService {

			//findAllCustomer
			List<Customer> findAllCustomer();
			
			
			//Search Customer by Account Number
			 Customer searchByAccNo(int accNo);
			 
			//Insert customer
			 Customer addCustomer(Customer customer);
			 
			
			//Update customer
			Customer updateCustomer(Customer customer);
		
			//Delete Customer
			Customer deleteCustomer(int accNo);
			
			//Deposit money-- Customer
			Customer deposit(int accNo, int amt);
			
			//Withdraw money -- Customer
			Customer withdraw(int accNo,int amt);
			
			//show balance
			int showBalance(int accNo);
	
}
