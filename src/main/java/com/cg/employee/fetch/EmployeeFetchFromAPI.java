package com.cg.employee.fetch;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cg.employee.model.Employee;
import com.cg.employee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EmployeeFetchFromAPI {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeService service;
	
	  @Value("${pageSize}")
	    private int pageSize;

	public void fetchEmployeeFromAPI() throws JsonParseException, IOException {
		boolean isDataAvailable = true;
		int i = 0;
		List<Employee> employeeList = null;
		while(isDataAvailable) {
			final String response  = restTemplate.getForObject("http://localhost:8080/employee/getAll?page="+i+"&size="+this.pageSize, String.class);
			ObjectMapper mapper = new ObjectMapper();
			JsonFactory factory = mapper.getFactory();
			JsonParser jsonParser = factory.createParser(response);
			JsonNode node = mapper.readTree(jsonParser);
			employeeList = mapper.readValue(node.get("content").toString(), new TypeReference<List<Employee>>() {} );
			service.addEmployeeRecords(employeeList);
			if (100 == employeeList.size()) {
				i++;
				isDataAvailable = true;
			} else 
				isDataAvailable = false;
			System.err.println(employeeList);
			employeeList =null;
			
		
		}
	}
}
