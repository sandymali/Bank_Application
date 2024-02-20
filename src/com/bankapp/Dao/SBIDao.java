package com.bankapp.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bankapp.model.Account;
import com.bankapp.serviceimp.AccountMapper;

public class SBIDao {
	Scanner sc=new Scanner(System.in);

	private JdbcTemplate template;

	

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	

	public void Save(String name, long acno, String address, long addharno, String panno, String gender, Double balance,
			long mob) {
	String insert = "insert into List values ('"+name+"','"+address+"',"+mob+","+addharno+",'"+panno+"','"+gender+"',"+acno+","+balance+")";
		
		template.batchUpdate(insert);
		System.out.println("data inserted");
		
	}



	public void get(long ac) {
		
		String get="select * from list where accountno="+ac+"";
		
		Account acn =  template.queryForObject(get, new AccountMapper());
		System.out.println("Account Holders name: "+acn.getName());
		System.out.println("account no :-"+acn.getAcno());
		System.out.println("address :-"+acn.getAddress());
		System.out.println("Addhar number :-"+acn.getAddharno());
		System.out.println("Pan number :-"+acn.getPanno());
		System.out.println("Mobile no :-"+acn.getMobileno());
		System.out.println("Gender :-"+acn.getGender());
		System.out.println("Balance :-"+acn.getBalance());
		
		
		//List<Account> alist = template.query(get, new AccountMapper());
		
	}



	public void Deposite(long acno) {
		
		String al="select * from list";
		long n=acno;
		List<Account> alist = template.query(al, new AccountMapper());
		List<Long> acnolist= new ArrayList<>();
		List<String> slist = new ArrayList<>();
		for(Account ac : alist)
		{
			acnolist.add(ac.getAcno());
			
		}
		
		
//		for(Long l :acnolist)
//		{
//			slist.add(String.valueOf(l));
//		}
		
		  if(acnolist.contains(acno)==true)
		    {
			  String s = "select * from list where accountno="+acno+"";
			  Account a = template.queryForObject(s, new AccountMapper());
			  double oldbal = a.getBalance();
			  
			 System.out.println("Enter amount deposited");
			 int amt=sc.nextInt();
			 
			 if(amt>=100)
			 {
				 double new_bal = oldbal + amt;
				 String depo = "update list set balance="+new_bal+" where accountno="+acno+"";
				 template.update(depo);
				 System.out.println("Money deposited");
			 }
			 
			 }
			 else
			 {
				 System.out.println("Account with given account is not available");
			 }
		 
				
		     String get="select * from List where accountno="+acno+"";
			
			Account ac = template.queryForObject(get, new AccountMapper());
			
		}



	public void withdraw(long acno) {
		String al="select * from list";
		long n=sc.nextLong();
		List<Account> alist=template.query(al,new AccountMapper());
		List<Long> acnolist = new ArrayList<>();
		List<String> slist = new ArrayList<>();
		
		for(Account ac : alist)
		{
			acnolist.add(ac.getAcno());
			
		}
		
		if(acnolist.contains(acno)==true)
		{
			String s="select * from list where accountno ="+acno+"";
			Account a=template.queryForObject(s, new AccountMapper());
			Double old_bal=a.getBalance();
			
			System.out.println("Enter amount withdraw");
			int amt=sc.nextInt();
			
			if(amt>=500 && amt<=20000)
			{
				double nw_bal=old_bal-amt;
				String with="update list set balance="+nw_bal+"where accountno ="+acno+"";
				template.batchUpdate(with);
				System.out.println("Money withdraw");
				
			}
			else
			{
				System.out.println("Enter less than 20000 and greater than 500");
			}
		}
		else {
			System.out.println("Account with given account is not available");
		 
		}
		
		 String get="select * from List where accountno="+acno+"";
			
			Account ac = template.queryForObject(get, new AccountMapper());
			
		
	}
		
		
		
		
		
		
		
		
		
		
	
		
		
	   
	
	
	
}
