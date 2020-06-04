/**
 * This API developed for ANZ and managed by Cognizant
 */
/**
 * @author Rakesh
 *
 */

package com.anz.api.account.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.anz.api.account.model.AccountsDetails;
import com.anz.api.account.model.AccountsTransactionDetails;

/**
 * 
 * @author Rakesh
 *
 */
public interface AccountService {

	/**
	 * 
	 * @param customerId
	 * @param limit
	 * @return
	 */
	public Collection<List<AccountsDetails>> getAccountDetails(String customerId, Optional<Integer> limit);

	/**
	 * 
	 * @param accountNumber
	 * @param limit
	 * @return
	 */
	public Collection<List<AccountsTransactionDetails>> getAccountTransactionDetails(String accountNumber,
			Optional<Integer> limit);

}
