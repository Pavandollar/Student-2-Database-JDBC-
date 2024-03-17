package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentImpl implements StudentInterface  
{
Scanner scanner = new Scanner(System.in);

	@Override
	public void saveStudent() 
	{
     
		System.out.println("Enter the Id");
		int id = scanner.nextInt();
		System.out.println("Enter the Name");
		String name = scanner.next();
		System.out.println("Enter the Age");
		int age = scanner.nextInt();
		System.out.println("Enter the Marks");
		double marks = scanner.nextDouble();
		
		
		
		try
		{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/student1","root","root");
	PreparedStatement preparedStatement = connection.prepareStatement("insert into student1 values(?,?,?,?)");
	preparedStatement.setInt(1, id);
	preparedStatement.setString(2,name);
	preparedStatement.setInt(3, age);
	preparedStatement.setDouble(4, marks);
	preparedStatement.execute();
	connection.close();
	System.out.println("data saved");
		
	}
		
		catch(ClassNotFoundException | SQLException e)
		  {
			e.printStackTrace();
		 }
	}
	@Override
	public void deleteStudent() 
	{
      System.out.println("Enter The Id");
	  int id = scanner.nextInt();
	  

		try
		{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/student1","root","root");
	PreparedStatement preparedStatement = connection.prepareStatement("delete from student1 where id = ?");
	preparedStatement.setInt(1, id);
	preparedStatement.execute();
	connection.close();
	System.out.println("data Deleted");
		}

	catch(ClassNotFoundException | SQLException e)
	  {
		e.printStackTrace();
	 }

	}

	@Override
	public void updateStudent() 
	{
	    System.out.println("Enter The Id");
	    int id = scanner.nextInt();
		System.out.println("Update The Student  Marks");
		double marks = scanner.nextDouble();


		try
		{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/student1","root","root");
	PreparedStatement preparedStatement = connection.prepareStatement("update student1 set marks = ? where id = ?");
	preparedStatement.setInt(1, id);
	preparedStatement.setDouble(1, marks);
	preparedStatement.execute();	
	connection.close();
	System.out.println("data updated");
		}

	catch(ClassNotFoundException | SQLException e)
	  {
		e.printStackTrace();
	 }

	}

	@Override
	public void getStudentByMarks() 
	{
      System.out.println("Enter Student By Marks");
  	double marks = scanner.nextDouble();
  	
  	

	try
	{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/student1","root","root");
PreparedStatement preparedStatement = connection.prepareStatement("select * from student1 where marks > ?");
preparedStatement.setDouble(1, marks);

ResultSet rs = preparedStatement.executeQuery();
while(rs.next())
{
	System.out.println("Student Id = "+ rs.getInt(1));
	System.out.println("Student Name = "+ rs.getString(2));
	System.out.println("Student Age = "+ rs.getInt(3));
	System.out.println("Student Marks = "+ rs.getDouble(4));


}
preparedStatement.execute();	
connection.close();
System.out.println("Got The Data");
	}

catch(ClassNotFoundException | SQLException e)
  {
	e.printStackTrace();
 }

}

	@Override
	public void getAllStudent() 
	{

		try
		{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/student1","root","root");
	PreparedStatement preparedStatement = connection.prepareStatement("select * from student1 ");

	ResultSet rs = preparedStatement.executeQuery();
	while(rs.next())
	{
		System.out.println("Student Id = "+ rs.getInt(1));
		System.out.println("Student Name = "+ rs.getString(2));
		System.out.println("Student Age = "+ rs.getInt(3));
		System.out.println("Student Marks = "+ rs.getDouble(4));


	}

	connection.close();
	System.out.println("Student Details Updated");
		}

	catch(ClassNotFoundException | SQLException e)
	  {
		e.printStackTrace();
	 }

	}

}
