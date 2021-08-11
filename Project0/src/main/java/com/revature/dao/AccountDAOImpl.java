package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dto.AddOrEditAccountDTO;
import com.revature.dto.AddOrEditClientDTO;
import com.revature.model.Account;
import com.revature.model.Client;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public List<Account> getAllAccountsFromClient(int clientID) throws SQLException {

		try (Connection con = ConnectionUtil.getCon()) {

			List<Account> accounts = new ArrayList<>();

			String sql = "SELECT * FROM clients.accounts q WHERE q.clientID = ?";

			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, clientID);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				int AID = rs.getInt("accountID");
				int CID = rs.getInt("clientID");
				float AB = rs.getFloat("accountBal");

				Account a = new Account(AID, CID, AB);
				accounts.add(a);
			}

			return accounts;
		}
	}

	@Override
	public List<Account> getAllAccountsFromClientBtw(int clientID) throws SQLException {

		try (Connection con = ConnectionUtil.getCon()) {

			List<Account> accounts = new ArrayList<>();

			String sql = "SELECT * FROM clients.accounts q WHERE q.clientID = ? AND accountBal between 400 and 2000";

			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, clientID);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				int AID = rs.getInt("accountID");
				int CID = rs.getInt("clientID");
				float AB = rs.getFloat("accountBal");

				if (AB > 400 && AB < 4000) {
					Account a = new Account(AID, CID, AB);
					accounts.add(a);
				}
			}

			return accounts;
		}
	}

	@Override
	public Account getAccountByIdFromClient(int clientID, int accountID) throws SQLException {

		try (Connection con = ConnectionUtil.getCon()) {

			String sql = "SELECT * FROM clients.accounts q WHERE q.clientID = ? AND q.accountID = ?";

			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, clientID);
			pstat.setInt(2, accountID);

			ResultSet rs = pstat.executeQuery();

			if (rs.next()) {
				int AID = rs.getInt("accountID");
				int CID = rs.getInt("clientID");
				float AB = rs.getFloat("accountBal");

				Account account = new Account(AID, CID, AB);

				return account;
			} else {
				return null;
			}
		}
	}

	@Override
	public Account addAccountByClientId(AddOrEditAccountDTO account) throws SQLException {
		try (Connection con = ConnectionUtil.getCon()) {
			String sql = "INSERT INTO clients.accounts (accountID, clientID, accountBal) VALUES (?, ?, ?)";

			PreparedStatement pstat = con.prepareStatement(sql);

			pstat.setInt(1, account.getAccountID());
			pstat.setInt(2, account.getClientID());
			pstat.setDouble(3, account.getAccountBal());

			int recordsUpdated = pstat.executeUpdate();

			if (recordsUpdated != 1) {
				throw new SQLException("Could not insert a account record");
			}

			Account newAccount = new Account(account.getAccountID(), account.getClientID(),
					account.getAccountBal());

			return newAccount;
		}
	}

	@Override
	public Account editAccount(int clientID, int accountID, AddOrEditAccountDTO account) throws SQLException {
		try (Connection con = ConnectionUtil.getCon()) {
			String sql = "UPDATE clients.accounts q SET accountBal = ?, clientID = ? WHERE q.clientID = ? AND q.accountID = ?";
			PreparedStatement pstat = con.prepareStatement(sql);

			pstat.setDouble(1, account.getAccountBal());
			pstat.setInt(2, account.getClientID());
			pstat.setInt(3, clientID);
			pstat.setInt(4, accountID);

			int recUp = pstat.executeUpdate();

			if (recUp != 1) {
				throw new SQLException("Unable to update record");
			}
			return new Account(account.getAccountID(), clientID, account.getAccountBal());
		}
	}

	@Override
	public void deleteAccountById(int clientID, int accountID) throws SQLException {
		try(Connection con = ConnectionUtil.getCon()){
			String sql = "DELETE FROM clients.accounts WHERE clientID = ? AND accountID = ?";

			PreparedStatement pstat = con.prepareStatement(sql);
			
			pstat.setInt(1, clientID);
			pstat.setInt(2, accountID);
			
			int recordsDeleted = pstat.executeUpdate();
			
			if (recordsDeleted != 1) {
				throw new SQLException("Unable to delete account");
			
			}
		}
		
	}
}
