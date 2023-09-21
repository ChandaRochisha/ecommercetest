package com.dnb.ecommerce.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//utilizations of the application
@Component
public class DBUtils {
	
		public DBUtils() {
			
		}
	@Autowired
		 DataSource dataSource;
	public Optional<Connection> getConnection() {
		
		try {

			Connection connection = dataSource.getConnection();
		
			return Optional.of(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public void closeConnection(Connection connection) {

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
	