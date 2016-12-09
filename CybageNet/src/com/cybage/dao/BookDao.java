package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cybage.bean.Book;
import com.cybage.connection.MyConnect;

public class BookDao {
	public int delete(String bookname) throws ClassNotFoundException, SQLException
	{
		Connection con=MyConnect.MyConnection();
		String query="delete from book where bookname=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, bookname);
		return st.executeUpdate();
	}
	
	public int insert(Book bk) throws ClassNotFoundException, SQLException
	{
		Connection con=MyConnect.MyConnection();
		String query="insert into book(bookname,author,price)values(?,?,?) ";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, bk.getBookname());
		st.setString(2, bk.getAuthor());
		st.setInt(3, bk.getPrice());
		return st.executeUpdate();
	}
	
	public Book search(String name) throws ClassNotFoundException, SQLException
	{
		Connection con=MyConnect.MyConnection();
		String query=" select * from book where bookname=? ";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, name);
		ResultSet rs= st.executeQuery();
		Book bookInstance=new Book();
		while(rs.next())
		{
			bookInstance.setBookname(rs.getString(2));
			bookInstance.setAuthor(rs.getString(3));
			bookInstance.setPrice(Integer.parseInt(rs.getString(4)));
		}
		 return bookInstance;
	}
}
