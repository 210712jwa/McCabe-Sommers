package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dto.AddOrEditClientDTO;
import com.revature.model.Client;
import com.revature.util.ConnectionUtil;

public class ClientDAOImpl implements ClientDAO {

	@Override
	public List<Client> getAllClients() throws SQLException {

		List<Client> clients = new ArrayList<>();

		try (Connection con = ConnectionUtil.getCon()) {

			Statement stat = con.createStatement();

			String sql = "SELECT * FROM clients";

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {

				String name = rs.getString("name");
				int client_id = rs.getInt("clientID");

				Client client = new Client(name, client_id);

				clients.add(client);
			}
		}

		return clients;
	}

	@Override
	public Client getClientById(int id) throws SQLException {
		try (Connection con = ConnectionUtil.getCon()) {
			String sql = "SELECT * FROM clients.clients WHERE clientID = ?";

			PreparedStatement pstat = con.prepareStatement(sql);

			pstat.setInt(1, id);

			ResultSet rs = pstat.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				int c_id = rs.getInt("clientID");

				Client client = new Client(name, c_id);

				return client;
			} else {
				return null;
			}
		}
	}

	@Override
	public Client addClient(AddOrEditClientDTO client) throws SQLException {
		try (Connection con = ConnectionUtil.getCon()) {
			String sql = "INSERT INTO clients.clients (name, clientID) VALUES (?, ?)";

			PreparedStatement pstat = con.prepareStatement(sql);

			pstat.setString(1, client.getName());
			pstat.setInt(2, client.getClientID());

			int recUp = pstat.executeUpdate(); 
			
			if (recUp != 1) {
				throw new SQLException("Unable to insert record");
			}

			Client newClient = new Client(client.getName(), client.getClientID());

			return newClient;
		}
	}

	@Override
	public Client editClient(int id, AddOrEditClientDTO client) throws SQLException {
		try (Connection con = ConnectionUtil.getCon()) {

			String sql = "UPDATE clients.clients SET name = ?, clientID = ? WHERE clientID = ?";
			PreparedStatement pstat = con.prepareStatement(sql);

			pstat.setString(1, client.getName());
			pstat.setInt(2, client.getClientID());
			pstat.setInt(3, id);

			int recUp = pstat.executeUpdate();

			if (recUp != 1) {
				throw new SQLException("Unable to update record");
			}


			return new Client(client.getName(), id);
		}
	}

	@Override
	public void deleteClientById(int id) throws SQLException {
		try(Connection con = ConnectionUtil.getCon()){
			String sql = "DELETE FROM clients.clients WHERE clientID = ?";

			PreparedStatement pstat = con.prepareStatement(sql);

			pstat.setInt(1, id);
			
			int recordsDeleted = pstat.executeUpdate();

			if (recordsDeleted != 1) {
				throw new SQLException("Unable to delete record");
			
			}
		}
	}
}
