package addressbookpackage;

import java.util.ArrayList;
import java.util.Scanner;


public class AddressBook {
									
	
	private ArrayList<PersonDetails> adrbook= new ArrayList<PersonDetails>();
	
	public void setDetails() {
		
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Enter your first name");
		String first_name=sc.nextLine();
		System.out.println("Enter your last name");
		String last_name=sc.nextLine();
		System.out.println("Enter your address/block number/street name ");
		String address=sc.nextLine();
		System.out.println("Enter your city");
		String city=sc.nextLine();
		System.out.println("Enter your state");
		String state=sc.nextLine();
		System.out.println("Enter your zip/pincode");
		Long zip=sc.nextLong();
		sc.nextLine();
		System.out.println("Enter your phone number");
		String phone_number=sc.nextLine();
		System.out.println("Enter your email_id");
		String email_id=sc.nextLine();
		
		PersonDetails p=new PersonDetails(first_name, last_name, address, city, state, zip, phone_number,email_id);
		
		adrbook.add(p);
		System.out.println("Person details added successfully");
		
	}
	
	
public void editDetails(String name) {
		
		Scanner sc=new Scanner(System.in);
		String fname;
		int i=0;
		for(PersonDetails per:adrbook) {
			
			fname=per.getFirst_name();
			if(name.equals(fname)) break;
			i++;
		}
		
		if((i)==adrbook.size()) {
			System.out.println("No record found with such name");
			
		}
		
		else {
				
				System.out.println("Edit the first name");
				String first_name=sc.nextLine();
				System.out.println("Edit the last name");
				String last_name=sc.nextLine();
				System.out.println("Edit the address/block number/street name ");
				String address=sc.nextLine();
				System.out.println("Edit the city");
				String city=sc.nextLine();
				System.out.println("Edit the state");
				String state=sc.nextLine();
				System.out.println("Edit the zip/pincode");
				Long zip=sc.nextLong();
				sc.nextLine();
				System.out.println("Edit the phone number");
				String phone_number=sc.nextLine();
				System.out.println("Edit the email_id");
				String email_id=sc.nextLine();
				
				PersonDetails newPerson=new PersonDetails(first_name, last_name, address, city, state, zip, phone_number, email_id);
				adrbook.remove(i);
				adrbook.add(i, newPerson);
				
			System.out.println("Person details edited successfully");
		
		}
		
	}


public void removeRecord(String name) {
	
	Scanner sc=new Scanner(System.in);
	String fname;
	int i=0;
	for(PersonDetails per:adrbook) {
		
		fname=per.getFirst_name();
		if(name.equals(fname)) break;
		i++;
	}
	
	if((i)==adrbook.size()) {
		System.out.println("No record found with such name");
		
	}
	
	else {
			
			
			adrbook.remove(i);
			
			
		System.out.println("Person details removed successfully");
		}
	
}

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		System.out.println("Welcome to the addressbook\n");
		UserInterface UIntFace = new UserInterface();
		UIntFace.UserInterfaceFunction();		
		
	}
	

}


class UserInterface {
	
public  void UserInterfaceFunction() {
		
		Scanner sc=new Scanner(System.in);
		
		AddressBook AddressBookRecord = new AddressBook();
		int choice;
		String name;
		
		do {
		System.out.println("1.Add a entry to addressbook");
		System.out.println("2.Edit a entry of addressbook");
		System.out.println("3. Delete a entry of addressbook");
		System.out.println("4. Exit");
		System.out.println("Enter your choice"); 
		 choice=sc.nextInt();
		 sc.nextLine();
		
		switch (choice) {
		case 1: {
			AddressBookRecord.setDetails();
			break;
		}
		
		case 2: {
			System.out.println("Enter first name of person whose record is to be edited");
			name=sc.nextLine();
			AddressBookRecord.editDetails(name);
			break;
		}
		
		case 3: {
			System.out.println("Enter first name of person whose record is to be remove");
			name=sc.nextLine();
			AddressBookRecord.removeRecord(name);
			break;
		}
		
		}
		
		}while(choice!=4);
		
	}
}







