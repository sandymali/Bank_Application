package com.bankapp.serviceimp;

import java.util.Scanner;


import com.bankapp.Dao.SBIDao;
import com.bankapp.service.RBI;

public class SBI implements RBI{
	Scanner sc=new Scanner(System.in);
	
	private SBIDao sb;
	
	public void setSb(SBIDao sb)
	{
		this.sb=sb;
	}
	
	public void createAccount()
	{
		System.out.println("Enter your Name");
		String name=sc.next();
		System.out.println("Enter your Accountno");
		long acno=sc.nextLong();
		System.out.println("Enter your address");
		String address=sc.next();
		System.out.println("Enter your Addharcard no");
		long addharno=sc.nextLong();
		System.out.println("Enter your Pancard no");
		String Panno=sc.next();
		System.out.println("Enter the gender");
		String gender=sc.next();
		System.out.println("Enter your Account balance");
		Double balance=sc.nextDouble();
		System.out.println("Enter Mobile number");
		long mob = sc.nextLong();
		
		sb.Save(name,acno,address,addharno,Panno,gender,balance,mob);
		
		
	}
	public void viewAccountdetails()
	{
		System.out.println("Enter your Account number");
		long ac = sc.nextLong();
		sb.get(ac);
		
	} 
	public void depositeMoney() 
	{
		System.out.println("Enter your account no");
		long acno=sc.nextLong();
		
		sb.Deposite(acno);
			
	}
	public void withdrawMoney()
	{
		System.out.println("Enter your account no");
		long acno=sc.nextLong();
		
		sb.withdraw(acno);
	}
	public void viewBalance()
	{
		
	}
	public void updateDetails()
	{
		
	}
	

}
