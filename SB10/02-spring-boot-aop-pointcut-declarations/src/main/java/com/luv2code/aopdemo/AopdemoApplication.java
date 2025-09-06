package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,MembershipDAO membershipDAO,TrafficFortuneService theTrafficFortuneService)
	{
		return runner ->
		{
			// demoTheBeforeAdvice(accountDAO,membershipDAO);
			// demoTheAfterReturningAdvice(accountDAO, membershipDAO);
			// demoTheAfterThrowingAdvice(accountDAO, membershipDAO);
			// demoTheAfterAdvice(accountDAO, membershipDAO);
			demotheArounfService(theTrafficFortuneService);
		};
	}

	private void demotheArounfService(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain program : demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String data = theTrafficFortuneService.getFortune();
		System.out.println("\nMy fortune is : " + data);
		System.out.println("Finished!");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		List<Account> theAccount = null;
		try{
			boolean tripWire = false;
			theAccount = accountDAO.findAccounts(tripWire);
		}
		catch(Exception exc)
		{
			System.out.println("\n\nMain Program : .... caught exception : " + exc);
		}

		System.out.println("\n\n Main Program : demoTheAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(theAccount);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		List<Account> theAccount = null;
		try{
			boolean tripWire = true;
			theAccount = accountDAO.findAccounts(tripWire);
		}
		catch(Exception exc)
		{
			System.out.println("\n\nMain Program : .... caught exception : " + exc);
		}

		System.out.println("\n\n Main Program : demoTheAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(theAccount);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		List<Account> theAccount = accountDAO.findAccounts();
		System.out.println();

		System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");
		System.out.println("-----");
		System.out.println(theAccount);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO,MembershipDAO membershipDAO) {
		// call the business method
		Account myAccount = new Account("John","Platinum");
		accountDAO.addAccount(myAccount,true);
		accountDAO.doWork();

		// call the accountDAO getter/setter
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name =  accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		// call the membership business method
		membershipDAO.addMember();
		membershipDAO.goToSleep();
	}

}
