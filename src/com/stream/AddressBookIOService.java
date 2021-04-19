package com.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBookIOService {
	public static final String ADDRESS_BOOK_FILE = "C:\\Users\\Shree\\eclipse-workspace\\AddressBookUsingStream\\src\\com\\stream\\address_book_file.txt";

	public void writeContact(Contact contact) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(contact.toString()).append('\n');

		String line = contact.toString() + "\n";

		try {
			Files.write(Paths.get(ADDRESS_BOOK_FILE), line.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Contact> readAll() {
		try {
			return Files.lines(Paths.get(ADDRESS_BOOK_FILE)).map(String::trim).map(line -> createContact(line))
					.collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	private Contact createContact(String data) {
		String firstNameLable = "FirstName: ";
		String lastNameLable = "LastName: ";
		String addressLable = "Address: ";
		String cityLable = "City: ";
		String stateLable = "State: ";
		String zipLable = "ZipCode: ";
		String phoneNumberLable = "PhoneNumber: ";
		String emailLable = "EmailId: ";

		String firstNameValue = extractValue(data, data.indexOf(firstNameLable) + firstNameLable.length(),
				data.indexOf(lastNameLable));
		String lastNameValue = extractValue(data, data.indexOf(lastNameLable) + lastNameLable.length(),
				data.indexOf(addressLable));
		String addressValue = extractValue(data, data.indexOf(addressLable) + addressLable.length(),
				data.indexOf(cityLable));
		String cityValue = extractValue(data, data.indexOf(cityLable) + cityLable.length(), data.indexOf(stateLable));
		String stateValue = extractValue(data, data.indexOf(stateLable) + stateLable.length(), data.indexOf(zipLable));
		String zipValue = extractValue(data, data.indexOf(zipLable) + zipLable.length(),
				data.indexOf(phoneNumberLable));
		String phoneNumberValue = extractValue(data, data.indexOf(phoneNumberLable) + phoneNumberLable.length(),
				data.indexOf(emailLable));
		String emailValue = extractValue(data, data.indexOf(emailLable) + emailLable.length(), data.indexOf(" ]"));

		return new Contact(firstNameValue, lastNameValue, addressValue, cityValue, stateValue, zipValue,
				phoneNumberValue, emailValue);
	}

	private String extractValue(String data, int startIndex, int endIndex) {
		return data.substring(startIndex, endIndex).trim();
	}
}
