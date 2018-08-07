
package org.cap.service;

import org.cap.dao.AccountDaoImpl;
import org.cap.dao.IAccountDao;
import org.cap.exception.AccountNotFound;
import org.cap.exception.InsufficientBalance;
import org.cap.exception.InvalidCustomer;
import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.util.AccountUtil;

public class AccountServiceImpl implements IAccountService {

	private IAccountDao accountDao;
	public AccountServiceImpl() {
	}
	
	
	public AccountServiceImpl(IAccountDao accountDao2) {
		accountDao=accountDao2;
	}

	public Account createAccount(Customer customer, double amount) throws InvalidCustomer {
		if(customer!=null) {
			if(amount>=500) {
				Account account=new Account();
				account.setCustomer(customer);
				account.setOpeningBalance(amount);
				account.setAccountNo(AccountUtil.generateAccountNo());
				boolean flag=accountDao.addAccount(account);
		
				if(flag) {
					return account;	
				} else {
					return null;
				}
			
			}
				
	} else {
		throw new InvalidCustomer("Sorry!! Customer refers null");
	}
		return null;
	}


	public Account findAccountById(int accountNo) {
		return accountDao.findAccountById(accountNo);
	}


	public Account withdraw(int accountNo, double amount_withdraw) throws AccountNotFound, InsufficientBalance {
	
			Account account=accountDao.findAccountById(accountNo);
					if(account==null)
						throw new AccountNotFound("Sorry! accountNo does not exist");
					if(amount_withdraw>account.getOpeningBalance())
						throw new InsufficientBalance("Sorry! Insufficient Balance");
					account.setOpeningBalance(account.getOpeningBalance()-amount_withdraw);
					return account; 
			 

	}


	public Account updateBalance(int accountNo, double amount) {
		return accountDao.updateBalance(accountNo,amount);
	}
}
