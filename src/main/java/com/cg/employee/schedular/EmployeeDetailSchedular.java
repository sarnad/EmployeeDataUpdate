package com.cg.employee.schedular;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cg.employee.fetch.EmployeeFetchFromAPI;
import com.fasterxml.jackson.core.JsonParseException;

@Component
public class EmployeeDetailSchedular {
	
	@Autowired 
	private EmployeeFetchFromAPI employeeFetchFromAPI;
	
//	@Scheduled(cron = "0 * 9 * * ?")
	 @Scheduled(fixedRate = 10000000)
	 void fetchEmployeeDetail() throws JsonParseException, IOException {
		System.out.println("Schedule");
		employeeFetchFromAPI.fetchEmployeeFromAPI();
	}

}
