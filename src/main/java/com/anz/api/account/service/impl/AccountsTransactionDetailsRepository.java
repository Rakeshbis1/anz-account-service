package com.anz.api.account.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.anz.api.account.model.AccountsTransactionDetails;

public interface AccountsTransactionDetailsRepository extends Repository<AccountsTransactionDetails, Long> {

	Optional<List<AccountsTransactionDetails>> findAllByaccountNumber(String accountNumber);

}
