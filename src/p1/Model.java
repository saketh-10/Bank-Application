package p1;

import java.sql.*;
import java.util.ArrayList;

public class Model 
{
private String name;
private String accno;
private String balance;
private String custid;
private String pwd;
private String email;
String url="jdbc:oracle:thin:@//localHost:1521/XE";
String un="system";
String pw="system";
Connection con=null;
ResultSet res=null;
PreparedStatement pstmt=null;
	
	public String getName() {
	return name;
}
public String getAccno() {
	return accno;
}
public String getBalance() {
	return balance;
}
public String getCustid() {
	return custid;
}
public String getPwd() {
	return pwd;
}
public String getEmail() {
	return email;
}
	public void setName(String name) {
	this.name = name;
}
public void setAccno(String accno) {
	this.accno = accno;
}
public void setBalance(String balance) {
	this.balance = balance;
}
public void setCustid(String custid) {
	this.custid = custid;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public void setEmail(String email) {
	this.email = email;
}
public Model()
{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(url, un, pw);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
	public boolean login()
	{
		try
		{
			String s="SELECT * FROM BANKAPP1 WHERE CUSTID=? AND PWD=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1,custid);
			pstmt.setString(2,pwd);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				accno=res.getString("ACCNO");
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean checkBalance()
	{
		try
		{
			String s="SELECT * FROM BANKAPP1 WHERE ACCNO=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1,accno);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				balance=res.getString("BALANCE");
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean changePassword()
	{
		try
		{
			String s="UPDATE BANKAPP1 SET PWD=? WHERE ACCNO=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, pwd);
			pstmt.setString(2, accno);
			int row=pstmt.executeUpdate();
			if (row==0)
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	public boolean transfer(String tamt)
	  {
		  try
		  {
			  String s="UPDATE BANKAPP1 SET BALANCE=BALANCE-? WHERE ACCNO=?";
			  pstmt=con.prepareStatement(s);
			  pstmt.setString(1,tamt);
			  pstmt.setString(2,accno);
			  int row=pstmt.executeUpdate();
			  String s1="INSERT INTO MINISTATEMENT VALUES(?,?)";
			  pstmt=con.prepareStatement(s1);
			  pstmt.setString(1,accno);
			  pstmt.setString(2,tamt);
			  pstmt.executeUpdate();
			  if (row==0)
			  {
				  return false;
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  return true;
	  }
	public ArrayList getStatement()
	{
		ArrayList al=new ArrayList();
		try
		{
			
			String s="SELECT * FROM MINISTATEMENT WHERE ACCNO=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, accno);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				String temp=res.getString("TAMT");
				al.add(temp);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
	public boolean applyLoan()
	{
		try
		{
			String s="SELECT * FROM BANKAPP1 WHERE ACCNO=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, accno);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				name=res.getString("NAME");
				email=res.getString("EMAIL");
				return true;
			}
		}
		catch(Exception e)	
		{
			e.printStackTrace();
		}
		return false;
	}
}
