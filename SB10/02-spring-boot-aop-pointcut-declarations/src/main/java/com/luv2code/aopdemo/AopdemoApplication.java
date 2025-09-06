package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,MembershipDAO membershipDAO)
	{
		return runner ->
		{
			// demoTheBeforeAdvice(accountDAO,membershipDAO);
			demoTheAfterReturningAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		List<Account> theAccount = accountDAO.findAccounts();
		System.out.println();

		System.out.println("\n\n Main Progress : demoTheAfterReturningAdvice");
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
