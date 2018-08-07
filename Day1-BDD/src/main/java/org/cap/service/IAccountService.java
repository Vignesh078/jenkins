package org.cap.service;

import org.cap.exception.AccountNotFound;
import org.cap.exception.InsufficientBalance;
import org.cap.exception.InvalidCustomer;
import org.cap.model.Account;
import org.cap.model.Customer;

public interface IAccountService {
	public Account createAccount(Customer customer,double openingBalance) throws InvalidCustomer;
	public Account findAccountById(int accountNo);
	public Account withdraw(int accountNo, double amount_withdraw) throws AccountNotFound, InsufficientBalance;
	public Account updateBalance(int accountNo, double amount);
}
