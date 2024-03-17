package com.Student;

import java.util.Scanner;

public class Student 
{
public static void main(String[] args) 
{
try (Scanner scanner = new Scanner(System.in)) {
	StudentInterface s1 = new StudentImpl();
	
	while(true)
	{
		System.out.println("STUDENT DATABASE");
		System.out.println("1:saveStudent\n2:deleteStudent\n3:updateStudent\n4:getStudentByMarks\n5:getAllStudent");
		System.out.println("Enter the choice 1 to 5");
		int choice = scanner.nextInt();
		
		
		switch(choice)
		{
		case 1 : s1.saveStudent();
		break;
		
		case 2 : s1.deleteStudent();
		break;
		
		case 3 : s1.updateStudent();
		break;
		
		case 4 : s1.getStudentByMarks();
		break;
		
		case 5 : s1.getAllStudent();
		break;
		
	     
		default : System.out.println("Invalid Choice");
		
		}
		
	}
}



}
}
