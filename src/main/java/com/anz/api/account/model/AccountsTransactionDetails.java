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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Account_Transaction_Details")
public class AccountsTransactionDetails implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@Column(name = "ID")

	private Integer id;

	@Column(name = "ACCOUNT_NUMBER")
	@JsonProperty("Account Number")
	private String accountNumber;

	@Column(name = "ACCOUNT_NAME")
	@JsonProperty("Account Name")
	private String accountName;

	@Column(name = "VALUE_DATE")
	@JsonProperty("Value Date")
	private Date valueDate;

	@Column(name = "ACCOUNT_CURR")
	@JsonProperty("Currency")
	private String currency;

	@Column(name = "DEBIT_AMOUNT")
	@JsonProperty("Debit Amount")
	private BigDecimal debitAmount;

	@Column(name = "CREDIT_AMOUNT")
	@JsonProperty("Credit Amount")
	private BigDecimal creditAmount;

	@Column(name = "TRANSACTION_TYPE")
	@JsonProperty("Debit-Credit")
	private String trnsactionType;

	@Column(name = "NARRATION")
	@JsonProperty("Transaction Narrative")
	private String transactionNarrative;

	@JsonIgnore
	@Column(name = "LAST_MODIFIED_DATE")
	private Timestamp LastModifiedDate;

	public AccountsTransactionDetails() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getTrnsactionType() {
		return trnsactionType;
	}

	public void setTrnsactionType(String trnsactionType) {
		this.trnsactionType = trnsactionType;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	@JsonIgnore
	public Timestamp getLastModifiedDate() {
		return LastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
