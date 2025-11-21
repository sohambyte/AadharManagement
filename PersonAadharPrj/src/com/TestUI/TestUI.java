package com.TestUI;

import java.util.Scanner;


import com.logic.Logic;

public class TestUI {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in); 
Logic l=new Logic();
	while(true) {
	System.out.println("---------****----------\n"
			+ "Welcome to CJC  \n"
			+ "Select the Option from below :\n"
			+ "1. Add Person \n"
			+ "2. View All Persons \n"
			+ "3. View Particular"
			+ "4. Update Person\n"
			+ "5. Delete Person\n"
			+ "0. Exit ");
	int ch=sc.nextInt();
	switch(ch) {
	
	case 1:
		l.insert();
		break;
	case 2:
		l.showall();
		break;
	case 3:
		l.show();
		break;
	case 4:
		l.update();
		break;
	case 5:
		l.delete();
		break;
	
		
		default:
//			System.exit(0);
			System.out.println("thankyou ");
	}
	if(ch==0) {
		break;
	}
	}
	
}
}

