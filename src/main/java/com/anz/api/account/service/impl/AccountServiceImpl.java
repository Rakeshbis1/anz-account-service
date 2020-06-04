package com.anz.api.account.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.anz.api.account.exception.AccountsNotFoundException;
import com.anz.api.account.model.AccountsDetails;
import com.anz.api.account.model.AccountsTransactionDetails;
import com.anz.api.account.service.AccountService;

/**
 * 
 * @author Rakesh
 *
 */
@Component("AccountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountsTransactionDetailsRepository accountsTransactionDetailsRepository;
	private final AccountsDetailsRepository accountsDetailsRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
	final AtomicInteger counter = new AtomicInteger();

	private Integer pageSize = 5;

	private Collection<List<AccountsDetails>> result;
	private Collection<List<AccountsTransactionDetails>> resultForAccountTransaction;;

	public AccountServiceImpl(AccountsDetailsRepository accountsDetailsRepository) {
		this.accountsDetailsRepository = accountsDetailsRepository;
	}

	@Override
	public Collection<List<AccountsDetails>> getAccountDetails(String customerId, Optional<Integer> limit) {

		// TODO Auto-generated method stub

		LOGGER.info("Inside getAccountDetails Service call ");
		LOGGER.info("Service Start Time----", java.time.LocalDate.now());

		if (limit.isPresent()) {
			pageSize = limit.get();
		}

		Optional<List<AccountsDetails>> getAccountServiceDetails = accountsDetailsRepository
				.findAllBycustomerId(customerId);

		if (getAccountServiceDetails.isPresent()) {
			result = getAccountServiceDetails.get().stream()
					.collect(Collectors.groupingBy(it -> counter.getAndIncrement() / pageSize)).values();
		} else {
			throw new AccountsNotFoundException(customerId);
		}

		LOGGER.info("Service End  Time----", java.time.LocalDate.now());
		LOGGER.info("End getAccountDetails service call ");
		return result;

	}

	@Override
	public Collection<List<AccountsTransactionDetails>> getAccountTransactionDetails(String accountNumber,
			Optional<Integer> limit) {
		// TODO Auto-generated method stub
		LOGGER.info("Inside getAccountTransactionDetails Service call ");
		LOGGER.info("Service Start Time----", java.time.LocalDate.now());

		if (limit.isPresent()) {
			pageSize = limit.get();
		}

		Optional<List<AccountsTransactionDetails>> getAccountTransactionsDetailsData = accountsTransactionDetailsRepository
				.findAllByaccountNumber(accountNumber);

		if (getAccountTransactionsDetailsData.isPresent()) {
			resultForAccountTransaction = getAccountTransactionsDetailsData.get().stream()
					.collect(Collectors.groupingBy(it -> counter.getAndIncrement() / pageSize)).values();
		} else {
			throw new AccountsNotFoundException(accountNumber);
		}

		LOGGER.info("Service End  Time----", java.time.LocalDate.now());
		LOGGER.info("End getAccountTransactionDetails service call ");
		return resultForAccountTransaction;
	}

}
