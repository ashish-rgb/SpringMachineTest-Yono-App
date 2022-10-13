package com.nissan.model;

import java.util.Random;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblCustomer")
public class Customer {

	
	
	//Fields
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int accNo;
		
		@Column(nullable=false,unique=true)
		private String cusName;
		
		@Column(nullable=false)
		private String accType;
		private int balance;
		private int mobNo;
		private boolean isActive;
		private String emailId;
	    private int atmPin;
	    private String panCard;
		
		   

		//default constructor
		public Customer() {
			super();
		}


		//parameterized
				public Customer(int accNo, String cusName, String accType, int balance, int mobNo, boolean isActive,
						String emailId, int atmPin, String panCard) {
					super();
					this.accNo = accNo;
					this.cusName = cusName;
					this.accType = accType;
					this.balance = balance;
					this.mobNo = mobNo;
					this.isActive = isActive;
					this.emailId = emailId;
					this.atmPin = atmPin;
					this.panCard = panCard;
				}

				
		//getters and setters
		public int getAccNo() {
			return generateAccountNo();
		}



		public void setAccNo() {
			this.accNo = generateAccountNo();
		}



		public String getCusName() {
			return cusName;
		}



		public void setCusName(String cusName) {
			this.cusName = cusName;
		}



		public String getAccType() {
			return accType;
		}



		public void setAccType(String accType) {
			this.accType = accType;
		}



		public int getBalance() {
			return balance;
		}



		public void setBalance(int balance) {
			this.balance = balance;
		}



		public int getMobNo() {
			return mobNo;
		}



		public void setMobNo(int mobNo) {
			this.mobNo = mobNo;
		}



		public boolean isActive() {
			return isActive;
		}



		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}



		public String getEmailId() {
			return emailId;
		}



		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}



		public int getAtmPin() {
			return generatePin();
		}



		public void setAtmPin() {
			this.atmPin = generatePin();
		}



		public String getPanCard() {
			return panCard;
		}



		public void setPanCard(String panCard) {
			this.panCard = panCard;
		}


		//override toString
		@Override
		public String toString() {
			return "Customer [accNo=" + accNo + ", cusName=" + cusName + ", accType=" + accType + ", balance=" + balance
					+ ", mobNo=" + mobNo + ", isActive=" + isActive + ", emailId=" + emailId + ", atmPin=" + atmPin
					+ ", panCard=" + panCard + "]";
		}
		
		static Random rand = new Random();

		// Custom method to Generate Account No.
				private static int generateAccountNo() {

					// 9 Digit Account No. only Digits allowed

					int accNo= rand.nextInt(900000000) + 100000000;
			         
			         return accNo;

				}

				// Custom Method to Generate PIN
				private static int generatePin() {

					int atmPin= rand.nextInt(9000) + 1000;
				       
		            return atmPin;
				}
}
