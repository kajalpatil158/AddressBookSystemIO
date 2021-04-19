package com.stream;

import java.util.List;
import java.util.Scanner;

/*@Description Here In Address Book Created a MenuBar
 * There is number of function created like 
 * Add Contact, Show contact, Edit Contact, Delete Contact
 * Search The Contact Using City
 * Search The Contact Using state
 * Number of contact by same city
 * Number of contacts by same state
 * Choose any case from above.
 * */
public class AddressBookStream {
	static class MenuBar {

		static Scanner sc = new Scanner(System.in);
		static AddressBookIOService addressBookIOService = new AddressBookIOService();

		// Select Options
		public static void optionChoice() {
			boolean ans = true;
			while (ans != false) {
				System.out.println("Please Enter Your Choice");
				System.out.println("1 Add New Contact");
				System.out.println("2 Show");
				System.out.println("3 Edit The Contact ");
				System.out.println("4 Delete The Contact");
				System.out.println("5 Search The Contact Using City");
				System.out.println("6 Search The Contact Using State");
				System.out.println("7 Number Of Contacts By Same City");
				System.out.println("8 Number Of Contacts By Same State");
				System.out.println("9 Exit");
				int choice = sc.nextInt();
				switch (choice) {

				case 1:
					MenuBar m = new MenuBar();
					m.newContact();
					break;
				case 2:
					show();
					break;
				case 3:
					editContact();
					break;
				case 4:
					deleteContact();
					break;
				case 5:
					searchByCity();
					break;
				case 6:
					searchByState();
					break;
				case 7:
					countByCity();
					break;
				case 8:
					countByState();
					break;
				case 9:
					ans = false;
					break;

				}

			}
		}
		/*
		 * create a new contact of fileds firstname,
		 * lastnane,address,city,state,zip,phonenumber,email all that fields
		 */

		public void newContact() {
			System.out.println("Enter The How Many Person You Want To Add");
			int no = sc.nextInt();
			for (int i = 0; i < no; i++) {
				System.out.println("Enter The First Name");
				String fName = sc.next();
				if (checkDuplicate(fName)) {
					System.out.println("Person is already exist");
				} else {
					System.out.println("Enter The Last Name");
					String lName = sc.next();
					System.out.println("Enter The Address");
					String address = sc.next();
					System.out.println("Enter The City");
					String city = sc.next();
					System.out.println("Enter The State");
					String state = sc.next();
					System.out.println("Enter The Zip Code");
					String zip = sc.next();
					System.out.println("Enter The Phone Number");
					String phoneNumber = sc.next();
					System.out.println("Enter The Email Address");
					String email = sc.next();
					Contact contact = new Contact(fName, lName, address, city, state, zip, phoneNumber, email);
					addressBookIOService.writeContact(contact);

				}

			}

		}

		// Check Is Data Is Duplicate or not.
		public boolean checkDuplicate(String fname) {
			int flag = 0;
			List<Contact> contacts = addressBookIOService.readAll();
			for (Contact contact : contacts) {
				if (contact.getfirstName().equals(fname)) {
					flag = 1;
					break;
				}
			}
			return flag == 1;
		}

		public static void show() {
			List<Contact> contacts = addressBookIOService.readAll();
			for (Contact contact : contacts) {
				System.out.println(contact);
			}
		}

		// Count By City
		public static void countByCity() {
			System.out.println("Enter The City Name You Want To Count Contacts");
			String city = sc.next();
			int count = 0;
			List<Contact> contacts = addressBookIOService.readAll();
			for (Contact contact : contacts) {
				if (contact.getcity().equals(city)) {
					count++;
					System.out.println("Number Of Person Is :" + count);
					break;
				} else {
					System.out.println("City Does Not Exist");
				}
			}

		}

		public static void countByState() {

			System.out.println("Enter The State Name You Want To Count Contacts");
			String state = sc.next();
			int count = 0;
			List<Contact> contacts = addressBookIOService.readAll();
			for (Contact contact : contacts) {
				if (contact.getstate().equals(state)) {
					count++;
					System.out.println("Number Of Person Is :" + count);
					break;
				} else {
					System.out.println("State Does Not Exist");
				}
			}
		}

		public static void searchByCity() {
			System.out.println("Enter The City You Want To Search");
			String city = sc.next();
			List<Contact> contacts = addressBookIOService.readAll();
			for (Contact contact : contacts) {
				if (contact.getcity().equals(city)) {

					System.out.println(contact);
					break;
				} else {
					System.out.println("City Does Not Exist");
				}
			}
		}

		public static void searchByState() {

			System.out.println("Enter The State You Want To Search");
			String state = sc.next();

			List<Contact> contacts = addressBookIOService.readAll();
			for (Contact contact : contacts) {
				if (contact.getstate().equals(state)) {

					System.out.println(contact);
					break;
				} else {
					System.out.println("State Does Not Exist");
				}
			}
		}

		public static void deleteContact() {
			System.out.println("Enter The First Name You Want To Delete");
			String fName = sc.next();
			List<Contact> contacts = addressBookIOService.readAll();
			for (int i = 0; i < contacts.size(); i++) {

				if (contacts.get(i).getfirstName().equalsIgnoreCase(fName)) {
					contacts.remove(i);
					System.out.println("Contact Delete Succesfully");
				} else {
					System.out.println("Contact Does Not Exist");
				}
			}
		}

		// Edit a added a contact.
		public static void editContact() {

			System.out.println("Enter The First Name You Want To Edit");
			String fName = sc.next();
			List<Contact> contacts = addressBookIOService.readAll();

			for (int i = 0; i < contacts.size(); i++) {

				if (contacts.get(i).getfirstName().equalsIgnoreCase(fName)) {
					System.out.println(contacts.get(i));
					System.out.println("Entet The Details Again\n");
					System.out.println("Enter The Last Name");
					String lName = sc.next();
					System.out.println("Enter The Address");
					String address = sc.next();
					System.out.println("Enter The City");
					String city = sc.next();
					System.out.println("Enter The State");
					String state = sc.next();
					System.out.println("Enter The Zip Code");
					String zip = sc.next();
					System.out.println("Enter The Phone Number");
					String phoneNumber = sc.next();
					System.out.println("Enter The Email Address");
					String email = sc.next();
					Contact contact = new Contact(fName, lName, address, city, state, zip, phoneNumber, email);
					addressBookIOService.writeContact(contact);
				} else {
					System.out.println("Contact Does Not Exist");
				}

			}
		}
	}

	// In main Execute a code Of MenuBar.
	public static void main(String args[]) {
		System.out.println("Welcome To Address Book Programmin");
		MenuBar obj = new MenuBar();
		obj.optionChoice();
	}
}