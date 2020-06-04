package com.anz.api.account.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.anz.api.account.model.AccountsDetails;

public interface AccountsDetailsRepository extends Repository<AccountsDetails, Long> {

	Optional<List<AccountsDetails>> findAllBycustomerId(String customerId);

}
