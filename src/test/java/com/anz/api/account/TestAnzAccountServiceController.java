package com.anz.api.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.anz.api.account.model.AccountsDetails;
import com.anz.api.account.model.AccountsTransactionDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AnzAccountServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestAnzAccountServiceController {
	
	private static final String HTTP_LOCALHOST = "http://localhost:";
	@LocalServerPort
	private Integer port = 8081;
	
	@Autowired
	private AnzAccountServiceController anzAccountServiceController;
	
	private final TestRestTemplate restTemplate = new TestRestTemplate();
	private final ObjectMapper mapper = new ObjectMapper();
	
	public String createUrlWithPort(final String uri){
		return HTTP_LOCALHOST+this.port+uri;
	}
	
	public ResponseEntity<String> createResponse(final String uri) {

		
		HttpEntity<String> httpEntity = new HttpEntity<>(null, null);
		return this.restTemplate.exchange(createUrlWithPort(uri), HttpMethod.GET, httpEntity, String.class);
	}
	
	/**
	 * <p>
	 * Checking pre-conditions
	 * </p>
	 */
	@BeforeEach
	public final void checkPreConditions() {

		assertThat(this.port).isNotNull();
		assertThat(this.restTemplate).isNotNull();
		assertThat(this.mapper).isNotNull();
	}

	
	
	private void checkResponseHeaderPostConditinons(final ResponseEntity<String> response,
			final HttpStatus expectedStatus, final String message) {

		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(expectedStatus);

	}

	private void checkActuatorPostConditions(final ResponseEntity<String> response, final String expectedBody) {

		checkResponseHeaderPostConditinons(response, HttpStatus.OK, null);
		assertThat(response.getBody()).contains(expectedBody);

	}
	
	private void checkPostConditions(final Collection<List<AccountsDetails>> accountDetails ,String customerId ) {
		 
		List<List<AccountsDetails>> listData=accountDetails.stream().collect(Collectors.toList());
		assertThat(accountDetails).isNotNull();
		assertThat(accountDetails.size()).isNotNull();
		assertThat(listData.size()).isNotNull();
		
	}
	
     private void checkPostConditionsForAccountTran(final Collection<List<AccountsTransactionDetails>> accountTransac ,String accountNumber ) {
		
    	 Collection<List<AccountsTransactionDetails>> accountTrsantionListData=accountTransac.stream().collect(Collectors.toList());
		assertThat(accountTransac).isNotNull();
		assertThat(accountTransac.size()).isNotNull();
		assertThat(accountTrsantionListData.size()).isNotNull();
		
	}
	
	
	/**
	 * @throws IOException Test for valid Parameter values
	 */
	@Test
	public final void testGetAccountDetails() throws IOException {

		final ResponseEntity<String> response = createResponse("custmers/getaccountlist/v1/ANZ10001");
	
		
		checkResponseHeaderPostConditinons(response, HttpStatus.OK, null);
		assertThat(response.getBody()).isNotBlank();

		final  Collection<List<AccountsDetails>> accountDetails  =  this.mapper.readValue(response.getBody(),
				Collection.class);
		checkPostConditions(accountDetails, "ANZ10001");

	}
     
     /**
 	 * @throws IOException Test for valid Parameter values
 	 */
        
 	@Test
 	public final void testGetAccountTransactionDetails() throws IOException {

 		final ResponseEntity<String> response = createResponse("custmers/getTransaction/v1/585309209");
 		checkResponseHeaderPostConditinons(response, HttpStatus.OK, null);
 		assertThat(response.getBody()).isNotBlank();

 		final Collection<List<AccountsTransactionDetails>> accountTranDetails  =  this.mapper.readValue(response.getBody(),
 				Collection.class);
 		checkPostConditionsForAccountTran(accountTranDetails, "1234");

 	}
 	
	
	


}
