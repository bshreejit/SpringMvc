package com.bshreejit.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {
	public boolean check(String uname, String pass)
	{
		String url="jdbc:mysql://127.0.0.1:3307/logindatabase";
		//String url="jdbc:mariadb://127.0.0.1:3307/logindatabase";
		String u="root";
		String p="admin";
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, u, p);
			
			PreparedStatement pst=con.prepareStatement("SELECT * FROM user where uname=? and pass=?");
			pst.setString(1, uname);
			pst.setString(2, pass);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
}
