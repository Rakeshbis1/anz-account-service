/**
 * This API developed for ANZ and managed by Cognizant
 */
/**
 * @author Rakesh
 *
 */
package com.anz.api.account.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "accounts_details")
public class AccountsDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@Column(name = "ID")
	private Integer id;

	@JsonIgnore
	@Column(name = "CUSTOMER_ID")
	private String customerId;

	@Column(name = "ACCOUNT_NUMBER")
	@JsonProperty("Account Number")
	private String accountNumber;

	@Column(name = "ACCOUNT_NAME")
	@JsonProperty("Account Name")
	private String accountName;

	@Column(name = "ACCOUNT_TYPE")
	@JsonProperty("Account Type")
	private String accountType;

	@Column(name = "BALANCE_DATE")
	@JsonProperty("Balance Date")
	private Date balanceDate;

	@Column(name = "ACCOUNT_CURR")
	@JsonProperty("Currency")
	private String currency;

	@Column(name = "ACCOUNT_BALANCE")
	@JsonProperty("Opening Available Balance")
	private BigDecimal openingAvailableBalance;

	@Column(name = "LAST_MODIFIED_DATE")
	@JsonIgnore
	private Timestamp LastModifiedDate;

	public AccountsDetails() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getOpeningAvailableBalance() {
		return openingAvailableBalance;
	}

	public void setOpeningAvailableBalance(BigDecimal openingAvailableBalance) {
		this.openingAvailableBalance = openingAvailableBalance;
	}

	@JsonIgnore
	public Timestamp getLastModifiedDate() {
		return LastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}

}
