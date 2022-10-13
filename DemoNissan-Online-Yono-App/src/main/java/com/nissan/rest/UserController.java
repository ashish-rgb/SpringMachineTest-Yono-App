package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Customer;
import com.nissan.service.ICustomerService;


@CrossOrigin		//helps to avoid CORS error
@RestController
@RequestMapping("api/")
public class UserController {

	//field DI Injection
		@Autowired
		ICustomerService cusService;
		
		//List all customers
		@GetMapping("adminitrators")
		public List<Customer> findAllCustomers(){
			return cusService.findAllCustomer();
		}
		
		
		//Get Customer by account number
		@GetMapping("adminitrators/{accNo}")
		public Customer searchByAccNo(@PathVariable int accNo) {
			System.out.println("Inside the controller");
			return cusService.searchByAccNo(accNo);
			}
			
		
		//Add Customer
		@PostMapping("adminitrators")
		public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
			System.out.println("Inserting a record");
			return new ResponseEntity<Customer> (cusService.addCustomer(customer),HttpStatus.OK);
		}
		
		//Update Customer
		@PutMapping("adminitrators")
		public Customer updateCustomer(@RequestBody Customer customer) {
			System.out.println("Updating a record");
			cusService.updateCustomer(customer);
			return customer;
		}
		
		//Delete Customer
		@DeleteMapping("adminitrators/delete/{accNo}")
		public Customer deleteCustomer(@PathVariable int accNo) {
			System.out.println("Deleting record");
			return cusService.deleteCustomer(accNo);
			}

		//deposit money
		@GetMapping("customers/deposit/{accNo}")
		public Customer deposit(@PathVariable int accNo,int amt) {
			System.out.println("deposit amount");
			return cusService.deposit(accNo,amt);
			}
		
		//withdraw money
		@GetMapping("customers/deposit/{accNo}")
		public Customer withdraw(@PathVariable int accNo,int amt) {
		System.out.println("withdraw amount");
		return cusService.withdraw(accNo,amt);
		}
		
		//show Balance
		@GetMapping("customers/{accNo}/balance")
		public int showBalance(@PathVariable int accNo) {
			return cusService.showBalance(accNo);
		}
}

