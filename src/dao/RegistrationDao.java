package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.LoginBean;
import database.DBConnection;

public class RegistrationDao {

	public String registerUser(LoginBean loginBean) {

		String userName = loginBean.getName(); // Keeping user entered values in temporary variables.
		String password = loginBean.getPassword();

		Connection con = null;
		Statement statement = null;
		PreparedStatement ps = null;

		try {
			con = DBConnection.createConnection(); // establishing connection
			statement = con.createStatement(); // Statement is used to write queries. Read more about it.
			ps = con.prepareStatement("insert into users (iduser, name, password) values (?,?,?)");
			ps.setInt(1, 3);
			ps.setString(2, userName);
			ps.setString(3, password);
			ps.executeUpdate();
			return "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials"; // Just returning appropriate message otherwise
	}

}
