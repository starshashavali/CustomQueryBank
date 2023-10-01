package com.org.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.domain.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer> {
	
	@Query(value="select * from Bank",nativeQuery=true)
	List<Bank> getAllBanks();
	
	
	@Query(value="select * from bank where bank_name=:name",nativeQuery=true)
	Bank getBankByName(@Param("name") String bankName);
	
	@Query(value="select * from bank where ifsc_code=:ifsc",nativeQuery=true)
	Bank getBankByIFSCCode(@Param("ifsc") String ifsc);


}
