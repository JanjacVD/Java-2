package hr.java.production.controller;

import hr.java.production.database.Data;
import hr.java.production.helpers.DataBuilder;
import hr.java.production.model.Address;
import hr.java.production.model.Factory;
import hr.java.production.model.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class FactoryController implements BaseController {

    private AddressController addressController;
    public FactoryController(AddressController _addressControler){
        this.addressController = _addressControler;
    }
    public ArrayList<Factory> index() {
        return Data.getInstance().factoryList;
    }

    public Factory create() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Create a factory");
            System.out.println("Enter name");
            String _name = scanner.nextLine();
            ArrayList<Item> _items = ItemController.selectMultiple();
            Address _address = addressController.create();
            Factory newFac = Factory.create(new DataBuilder("name", _name,"address",_address, "items", _items).build());
            Data.getInstance().factoryList.add(newFac);
            return newFac;
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
    public Factory getHighestVolumeFactory(){
        Factory factoryWithLargestVolume = null;
        BigDecimal largestVolume = BigDecimal.ZERO;
        for (Factory factory : Data.getInstance().factoryList) {
            for (Item item : factory.getItems()) {
                BigDecimal volume = item.calculateVolume();
                if (volume.compareTo(largestVolume) > 0) {
                    largestVolume = volume;
                    factoryWithLargestVolume = factory;
                }
            }
        }
        return factoryWithLargestVolume;
    }
}
