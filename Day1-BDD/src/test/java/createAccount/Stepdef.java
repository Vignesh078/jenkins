package createAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.cap.dao.IAccountDao;
import org.cap.model.Account;
import org.cap.model.Address;
import org.cap.model.Customer;
import org.cap.service.AccountServiceImpl;
import org.cap.service.IAccountService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef {
	   private Customer customer;
	   private double openingBalance;
	   private IAccountService accountService;
	   private int accountNo;
	   
	   @Mock
	   private IAccountDao accountDao;
	private double amount_withdraw;
	   
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		customer=new Customer();
		openingBalance=1000;
		accountService=new AccountServiceImpl(accountDao);
	}
	@Given("^For customer details$")
	public void for_customer_details() throws Throwable {
		customer.setFirstName("Vicky");
		customer.setLastName("Vignesh");
		Address address=new Address();
		address.setDoorNo("61/102");
		address.setCity("Chennai");
	   
	}

	@When("^Valid customer$")
	public void valid_customer() throws Throwable {
	   assertNotNull(customer);
	}

	@Then("^create new account$")
	public void create_new_account() throws Throwable {
		
		Account account=new Account();
		account.setAccountNo(1);
		account.setOpeningBalance(1000);
		account.setCustomer(customer);
		
	    //Mockito.when(accountDao.addAccount(account)).thenReturn(true);
	   accountService.createAccount(customer, openingBalance);
	   // Mockito.verify (accountDao).addAccount(account);
	    //assertNotNull(account2);
	   // assertEquals(openingBalance, account2.getOpeningBalance(),0.0);
	   // assertEquals(1, account2.getAccountNo());
	}

	@When("^valid openingBalance$")
	public void valid_openingBalance() throws Throwable {
	    assertTrue(openingBalance>=500);
	}
	@Given("^Account Number$")
	public void account_Number() throws Throwable {
	    accountNo=1;
	}

	@When("^Valid Account Number$")
	public void valid_Account_Number() throws Throwable {
	   
	}

	@Then("^Find Account Details$")
	public void find_Account_Details() throws Throwable {
	   Account account=new Account();
	   account.setAccountNo(1);
	   account.setCustomer(customer);
	   account.setOpeningBalance(10000);
	   
	   Mockito.when(accountDao.findAccountById(accountNo)).thenReturn(account);
	   Account account2=accountService.findAccountById(accountNo);
	   Mockito.verify(accountDao).findAccountById(accountNo);
	   assertEquals(account.getAccountNo(), account2.getAccountNo());
	   
	}
	@Given("^Account number (\\d+) and amount (\\d+)$")
	public void account_number_and_amount(int accNo, double amount) throws Throwable {
	    this.accountNo=accNo;
	    this.amount_withdraw=amount;
	    
	}

	@When("^Find account and do Withdraw$")
	public void find_account_and_do_Withdraw() throws Throwable {
		Account account=new Account();
		   account.setAccountNo(this.accountNo);
		   account.setCustomer(customer);
		   account.setOpeningBalance(10000);
		   
		   Mockito.when(accountDao.findAccountById(this.accountNo)).thenReturn(account);
		   Mockito.when(accountDao.updateBalance(accountNo,1000)).thenReturn(account);
	  Account account2 =accountService.withdraw(accountNo,amount_withdraw);
	  Mockito.verify(accountDao).findAccountById(1);
	 
	  assertEquals(9000, account2.getOpeningBalance(),0.0);
	  
	}

	@Then("^update the account details$")
	public void update_the_account_details() throws Throwable {
		Account account=new Account();
		account.setAccountNo(this.accountNo);
		account.setCustomer(customer);
		account.setOpeningBalance(1000);
		 Mockito.when(accountDao.updateBalance(accountNo,1000)).thenReturn(account);
		Account updated_account=accountService.updateBalance(accountNo, 1000);
		assertEquals(1000, updated_account.getOpeningBalance(),0.0);
		 
 

	}

}