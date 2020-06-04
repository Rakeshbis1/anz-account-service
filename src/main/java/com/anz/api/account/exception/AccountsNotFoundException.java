/**
 * This API developed for ANZ and managed by Cognizant
 */
/**
 * @author Rakesh
 *
 */

package com.anz.api.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Rakesh
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountsNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param exception
	 */
	public AccountsNotFoundException(String exception) {

		super(exception);
	}

}
