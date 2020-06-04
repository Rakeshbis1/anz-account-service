/**
 * This API developed for ANZ and managed by Cognizant
 */
/**
 * @author Rakesh
 *
 */

package com.anz.api.account;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anz.api.account.model.AccountsDetails;
import com.anz.api.account.model.AccountsTransactionDetails;
import com.anz.api.account.service.AccountService;

/**
 * 
 * @author Rakesh
 *
 */
@RestController
@RequestMapping("/custmers/")
public class AnzAccountServiceController {

	@Autowired
	private AccountService accountService;

	private static final Logger LOGGER = LoggerFactory.getLogger(AnzAccountServiceController.class);

	/**
	 * 
	 * @param customerId
	 * @return
	 */
	@GetMapping("getaccountlist/v1/{customerId}")
	public Collection<List<AccountsDetails>> getAccountDetails(
			@PathVariable("customerId") @Max(20) @Valid final String customerId,
			@RequestParam(value = "limit", required = false) @NumberFormat(style = NumberFormat.Style.NUMBER) @Min(1) @Valid final Optional<Integer> limit)

	{
		LOGGER.info("inside getAccountDetails- ");
		return accountService.getAccountDetails(customerId, limit);
	}

	/**
	 * 
	 * @param accountNumber
	 * @param limit
	 * @return
	 */
	@GetMapping("getTransaction/v1/{accountNumber}")
	public Collection<List<AccountsTransactionDetails>> getAccountTransactionDetails(
			@PathVariable("accountNumber") @Max(25) @Valid final String accountNumber,
			@RequestParam(value = "limit", required = false) @NumberFormat(style = NumberFormat.Style.NUMBER) @Min(1) @Valid final Optional<Integer> limit) {

		LOGGER.info("inside getAccountTransactionDetails- ");
		return accountService.getAccountTransactionDetails(accountNumber, limit);

	}

}
