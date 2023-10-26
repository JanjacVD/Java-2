package hr.java.production.controller;

import hr.java.production.database.Data;
import hr.java.production.helpers.DataBuilder;
import hr.java.production.model.Address;
import hr.java.production.model.Factory;
import hr.java.production.model.Item;
import hr.java.production.model.Store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreController  implements BaseController {

    public ArrayList<Store> index() {
        return Data.getInstance().storeList;
    }
    public Store create() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Create a store");
            System.out.println("Enter name");
            String _name = scanner.nextLine();
            System.out.println("Enter web address");
            String _web = scanner.nextLine();
            ArrayList<Item> _items = ItemController.selectMultiple();
            Store newStore = Store.create(new DataBuilder("name", _name,"webAddress",_web, "items", _items).build());
            Data.getInstance().storeList.add(newStore);
            return newStore;
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

    public void delete() {}

    public Store getCheapestItems(){
        Store storeWithCheapestItem = null;
        BigDecimal cheapestPrice = BigDecimal.valueOf(Double.MAX_VALUE);
        for (Store store : Data.getInstance().storeList) {
            for (Item item : store.getItems()) {
                if (item.getSellingPrice().compareTo(cheapestPrice) < 0) {
                    cheapestPrice = item.getSellingPrice();
                    storeWithCheapestItem = store;
                }
            }
        }
        return storeWithCheapestItem;
    }
}