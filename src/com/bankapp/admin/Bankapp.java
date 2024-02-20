package com.bankapp.admin;



import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.bankapp.serviceimp.SBI;

public class Bankapp {
	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		SBI ac = context.getBean(SBI.class);
		
	
		boolean flag=true;
		
		while(flag)
		{
			System.out.println("1.for create Account \n"
			       	+ "2.for view Account details \n"
			        +"3.for Deposite Money \n"
			       	+"4.for Withdraw money \n"
			        +"5.for view Account Balance \n"
			       	+"6.for Update Account Details\n"
			        +"7.for Exit");
	
	System.out.println("Enter the choice");
	int ch=sc.nextInt();
	
	switch(ch) 
	{
	case 1:
		ac.createAccount();
		break;
		
	case 2:
		ac.viewAccountdetails();
		break;
		
	case 3: 
		ac.depositeMoney();
		break;
		
	case 4:
		ac.withdrawMoney();
		break ;
		
	case 5:
		ac.viewBalance();
		break;
		
	case 6:
		ac.updateDetails();
		break;
		
	case 7:
		flag=false;
		System.out.println("Thank You for visit the SBI Bank");
		break;
		
    default :
    	System.out.println("you Entering wrong choice");
		break;	
		
		}
		}
		
		
	}
	
	
	

}
