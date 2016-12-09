package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cybage.bean.Review;
import com.cybage.connection.MyConnect;

public class ReviewDao {

	public int insertreview(Review rev) throws ClassNotFoundException, SQLException
	{
		Connection con=MyConnect.MyConnection();
		String query="insert into review(comment,bookname,user)values(?,?,?) ";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, rev.getComment());
		st.setString(2,rev.getBookname() );
		st.setString(3, rev.getUser());
		return st.executeUpdate();
	}
	
	public ArrayList<String> search(String bookname) throws ClassNotFoundException, SQLException
	{
		Connection con=MyConnect.MyConnection();
		String query=" select comment,user from review where bookname=? ";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, bookname);
		ResultSet rs= st.executeQuery();
		//Review reviewinstance=new Review();
		ArrayList<String> rlist=new ArrayList<>();
		ArrayList<String> userlist=new ArrayList<>();
		while(rs.next())
		{
			/*reviewinstance.setComment(rs.getString(2));
			reviewinstance.setBookname(rs.getString(3));
			reviewinstance.setUser((rs.getString(4)));*/
			rlist.add(rs.getString(1));
			userlist.add(rs.getString(2));
		}
		return rlist;
	}
}
