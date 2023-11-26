package hr.java.production.controller;

import hr.java.production.database.Data;
import hr.java.production.helpers.DataBuilder;
import hr.java.production.helpers.SelectHelper;
import hr.java.production.model.Address;
import hr.java.production.model.Category;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressController implements BaseController{
    public ArrayList<Address> index() {
        return Data.getInstance().addressList;
    }

    public Address create() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Create an address");
            System.out.println("Enter street name");
            String _sName = scanner.nextLine();
            System.out.println("Enter house number");
            String _hNumber = scanner.nextLine();
            System.out.println("Enter city");
            String _city = scanner.nextLine();
            System.out.println("Enter ZIP code");
            String _zip = scanner.nextLine();
            Address newAddress = Address.create(new DataBuilder("street", _sName, "houseNumber", _hNumber, "city", _city, "postalCode", _zip).build());
            Data.getInstance().addressList.add(newAddress);
            return newAddress;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Try again");
            return create();
        }
    }

    public void create(int n) {
        for (int i = 0; i < n; i++) {
            create();
        }
    }
    public void delete() {

    }
}
