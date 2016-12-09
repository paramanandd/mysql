package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cybage.bean.Login;
import com.cybage.connection.MyConnect;

public class LoginDao {
	static int count=0;
	public String validate(Login lg) throws SQLException, ClassNotFoundException
	{
	Connection  con=MyConnect.MyConnection();
	String query="select username,password,role from login where username=? and password=? ";
	PreparedStatement st=con.prepareStatement(query);
	st.setString(1, lg.getUser());
	st.setString(2, lg.getPassword());
	ResultSet rs=st.executeQuery();
	if(rs.next())
	{
		String role=rs.getString(3);
		System.out.println(role);
		return role;
	}
	else
	{
		return "invalid";
	}
}
}
