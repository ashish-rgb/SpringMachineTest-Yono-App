package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.nissan.model.Customer;


public interface ICustomerRepository extends JpaRepositoryImplementation<Customer, Integer>{

	
	//Custom Retrieve Account No
		@Query("from Customer where accNo=?1")
		public Customer searchByAccNo(int accNo);
		
		@Query("from Customer where accNo=?1")
		public Customer deleteAccNo(int accNo);
		
		@Query("from Customer where accNo=?1 & amt=?2")
		public Customer deposit(int accNo,int amt);
		
		@Query("from Customer where accNo=?1 & amt=?2")
		public Customer withdraw(int accNo,int amt);
		
		@Query("from Customer where accNo=?1")
		public int showBalance(int accNo);
}
