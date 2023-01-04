package com.userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.userModel.User;

public class UserDao 
{
	private static String url = "jdbc:mysql://localhost:3306/webproject";
	private static String username = "root";
	private static String password = "Sms@223345";
	private static String insert="insert into register(name,fathername,mothername,dob,gender,city) values(?,?,?,?,?,?)"; 
	private static String display = "select * from register";   // for displaying D.B object in front end.
	private static String delete = "delete from register where id=?";
	private static String selectUserById ="select * from register where id=?";
	private static String updateUser="update register set name=?,fathername=?,mothername=?,dob=?,gender=?,city=? where id=?";
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement s=null;
	 
	public static void insert(User u)
	{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username,password);
			ps = con.prepareStatement(insert);
			ps.setString(1,u.getName());
			ps.setString(2,u.getFathername());
			ps.setString(3,u.getMothername());
			ps.setString(4,u.getDob());
			ps.setString(5,u.getGender());
			ps.setString(6,u.getCity());
			ps.executeUpdate();
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			
		} catch (SQLException e) {
				e.printStackTrace();
			}
			finally
			{
				try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}
	
			//Display details(how to take data from back-end,this data should be displayed in userlist.jsp
			public static ArrayList<User> display()
			{
				ArrayList<User> al = new ArrayList<User>();
				
				try 
				{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url,username,password);
				s = con.createStatement();
				ResultSet rs = s.executeQuery(display);
				while(rs.next())
				{
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String fathername = rs.getString("fathername");
					String mothername = rs.getString("mothername");
					String dob = rs.getString("dob");
					String gender = rs.getString("gender");
					String city = rs.getString("city");
				User u =new User(id,name,fathername,mothername,dob,gender,city);
					
					al.add(u);             //Add this value to the array list
				}
				}
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				
			} catch (SQLException e) {
					e.printStackTrace();
				}
				finally
				{
					try {
						s.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
				return al;
			}
				
				//DELETE
				public static void delete(int id)
				{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection(url,username,password);
				ps = con.prepareStatement(delete);
				ps.setInt(1,id);
				ps.executeUpdate();
				}
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				
			} catch (SQLException e) {
					e.printStackTrace();
				}
				finally
				{
					try {
						ps.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
				//SELECT user by ID
				public static User selectUserById(int id1)
				{
					User u=null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection(url,username,password);
				ps = con.prepareStatement(selectUserById);
				ps.setInt(1,id1);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String fathername = rs.getString("fathername");
					String mothername = rs.getString("mothername");
					String dob = rs.getString("dob");
					String gender = rs.getString("gender");
					String city = rs.getString("city");
				u =new User(id,name,fathername,mothername,dob,gender,city);
					
				}
				}
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				
			} catch (SQLException e) {
					e.printStackTrace();
				}
				finally
				{
					try {
						ps.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return u;
				}
				
				//UPDATE USER
				
				
				public static void updateUser(User u)
				{
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						
						con = DriverManager.getConnection(url,username,password);
						ps = con.prepareStatement(updateUser);
						ps.setString(1,u.getName());
						ps.setString(2, u.getFathername());
						ps.setString(3, u.getMothername());
						ps.setString(4, u.getDob());
						ps.setString(5, u.getGender());
						ps.setString(6, u.getCity());
						ps.setInt(7, u.getId());
						ps.executeUpdate();
						}
						catch (ClassNotFoundException e) 
						{
							e.printStackTrace();
						
					} catch (SQLException e) {
							e.printStackTrace();
						}
						finally
						{
							try {
								ps.close();
								con.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}}
				
				
				
			
			


}
