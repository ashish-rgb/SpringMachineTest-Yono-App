package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.Customer;
import com.nissan.repo.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	//field injection
			@Autowired
			ICustomerRepository cusRepo;
			
			//find all customers
			@Override
			public List<Customer> findAllCustomer() {
				return (List<Customer>) cusRepo.findAll();
			}

			//search customer by account number
			@Override
			public Customer searchByAccNo(int accNo) {
				Customer _customer = cusRepo.searchByAccNo(accNo);
				
				//check condition
				if(accNo == _customer.getAccNo()) {
					return _customer;
				}else {
					return null;
				}
			}

			//add new customer
			@Transactional
			@Override
			public Customer addCustomer(Customer customer) {
				return cusRepo.save(customer);
			}

			//update customer
			@Override
			public Customer updateCustomer(Customer customer) {
				
				return cusRepo.save(customer);
			}

			//delete customer
			@Override
			public Customer deleteCustomer(int accNo) {
				Customer _customer = cusRepo.deleteAccNo(accNo);
				_customer.setActive(false);
				return _customer;
			}

			@Override
			public Customer deposit(int accNo,int amt) {  
				Customer _customer = cusRepo.deposit(accNo,amt);
				_customer.setBalance(_customer.getBalance() + amt);
				System.out.println("deposited amount" + amt);
				return _customer;
				}

			@Override
			public Customer withdraw(int accNo,int amt) {
				Customer _customer = cusRepo.withdraw(accNo,amt);
				_customer.setBalance(_customer.getBalance() - amt);
				System.out.println("withdraw " + amt);
				return _customer;
			}

			@Override
			public int showBalance(int accNo) {
				Customer _customer = new Customer();
				
				return _customer.getBalance();
				
			}
			
			

			

}
