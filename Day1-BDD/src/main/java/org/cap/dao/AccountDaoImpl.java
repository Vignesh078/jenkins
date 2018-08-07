package org.cap.dao;

import org.cap.model.Account;
import java.sql.*;

public class AccountDaoImpl implements IAccountDao {
 private  Connection connect;
 private Statement statement;
	public boolean addAccount(Account account) {
		String sql="insert into Account values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/cukesDB","root","India123");
			 PreparedStatement stat=connect.prepareStatement(sql);
			 stat.setInt(1, account.getAccountNo());
			 stat.setDouble(2, account.getOpeningBalance());
			 stat.setString(3, account.getCustomer().getFirstName());
			 int count=stat.executeUpdate();
			 System.out.println(count);
			 if(count>0)
				 return true;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public Account findAccountById(int accountNo) {
		
		return null;
	}
	public Account updateBalance(int accountNo, double amount) {
		// TODO Auto-generated method stub
		return null;
	}

}
