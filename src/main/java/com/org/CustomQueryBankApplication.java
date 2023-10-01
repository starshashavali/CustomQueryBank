package com.org;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.org.domain.Bank;
import com.org.repo.BankRepo;

@SpringBootApplication
public class CustomQueryBankApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context 
		= SpringApplication.run(CustomQueryBankApplication.class, args);
		BankRepo repo = context.getBean(BankRepo.class);
/*		
		Bank b=new Bank(301, "SBI", "SBIN0014414");
		repo.save(b);
		
		Bank b1=new Bank(302, "AXIS", "AXIS0014414");
		repo.save(b1);
		
		Bank b2=new Bank(303, "ANDRABANK", "ANDRABANK0014414");
		repo.save(b2);

		Bank b3=new Bank(304, "ICICI", "ICICI0014414");
		repo.save(b3);
		System.out.println("avaailable recoeds in db::"+repo.count());*/
		List<Bank> findAll = repo.findAll();
		for( Bank all:findAll ) {
			System.out.println(all);
		}
		System.out.println("=========================");
		Bank sbiBank = repo.getBankByName("SBI");
		System.out.println(sbiBank);
		System.out.println("===============");
		Bank bankByIFSCCode = repo.getBankByIFSCCode("AXIS0014414");
		System.out.println(bankByIFSCCode);
		
	}

}
