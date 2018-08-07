package createAccount;

import static org.junit.Assert.*;

import org.cap.exception.InvalidCustomer;
import org.cap.model.Address;
import org.cap.model.Customer;
import org.cap.service.AccountServiceImpl;
import org.cap.service.IAccountService;
import org.junit.Before;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;




public class createAccountTest {
	private 	Customer customer;
	private IAccountService accountService;
	
	@Before
	public void setUp() {
	customer=new Customer();
		customer.setFirstName("Vicky");
		customer.setLastName("Vignesh");
		Address address=new Address();
		address.setDoorNo("61/102");
		address.setCity("Chennai");
		accountService=new AccountServiceImpl();
	}
	@Rule
	public ExpectedException ex=ExpectedException.none();
	@Test
	public void test_Customer_With_Null() throws InvalidCustomer {
		customer=null;
		ex.expect(InvalidCustomer.class);
		ex.expectMessage("Sorry!! Customer refers null");
		accountService.createAccount(customer, 1000);
	}
    
}
