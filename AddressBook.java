package addressbookpackage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;


public class AddressBook {
									
	
	private TreeMap<String,ArrayList<PersonDetails>> adrbook= new TreeMap<String,ArrayList<PersonDetails>>();
	
	
	public void addressBookManager(String adrbookname,ArrayList<PersonDetails> per) {
		adrbook.put(adrbookname, per);
	}
	
	public ArrayList<PersonDetails> setDetails(ArrayList<PersonDetails> newDetails) {
		
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
		
		newDetails.add(p);
		System.out.println("Person details added successfully");
		return newDetails;
		
	}
	
	
public ArrayList<PersonDetails> editDetails(ArrayList<PersonDetails> editDetails,String name) {
		
		Scanner sc=new Scanner(System.in);
		String fname;
		int i=0;
		for(PersonDetails per:editDetails) {
			
			fname=per.getFirst_name();
			if(name.equals(fname)) break;
			i++;
		}
		
		if((i)==editDetails.size()) {
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
				editDetails.remove(i);
				editDetails.add(i, newPerson);
				
			System.out.println("Person details edited successfully");
			
		
		}
		return editDetails;
		
	}
 

public ArrayList<PersonDetails> removeRecord(ArrayList<PersonDetails> removeDetails,String name) {
	
	Scanner sc=new Scanner(System.in);
	String fname;
	int i=0;
	for(PersonDetails per:removeDetails) {
		
		fname=per.getFirst_name();
		if(name.equals(fname)) {break;}
		i++;
	}
	
	if((i)==removeDetails.size()) {
		System.out.println("No record found with such name");
		
	}
	
	else {
			
			
			removeDetails.remove(i);
			
			
		System.out.println("Person details removed successfully");
		
		}
	return removeDetails;
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
		
		ArrayList<PersonDetails> per=new ArrayList<PersonDetails>();
		AddressBook AddressBookRecord = new AddressBook();
		int choice;
		String name,adrbookname;
		do {
		System.out.println("please enter name of the address book ");
		adrbookname=sc.nextLine();
		
		
		do {
		System.out.println("1.Add a entry to addressbook");
		System.out.println("2.Edit a entry of addressbook");
		System.out.println("3. Delete a entry of addressbook");
		System.out.println("4. Exit the address book");
		System.out.println("Enter your choice"); 
		 choice=sc.nextInt();
		 sc.nextLine();
		
		switch (choice) {
		case 1: {
			per=AddressBookRecord.setDetails(per);
			break;
		}
		
		case 2: {
			System.out.println("Enter first name of person whose record is to be edited");
			name=sc.nextLine();
			per=AddressBookRecord.editDetails(per,name);
			break;
		}
		
		case 3: {
			System.out.println("Enter first name of person whose record is to be remove");
			name=sc.nextLine();
			per=AddressBookRecord.removeRecord(per,name);
			break;
		}
		
		}
		
		}while(choice!=4);
		
		AddressBookRecord.addressBookManager(adrbookname, per);
		
		System.out.println("1.Create a new addressbook");
		System.out.println("2.Exit the program");
		System.out.println("Enter the choice");
		choice=sc.nextInt();
		sc.nextLine();
		} while(choice!=2);
		
	}
}







