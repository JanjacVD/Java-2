package hr.java.production.main;

import hr.java.production.auth.Auth;
import hr.java.production.controller.*;
import hr.java.production.database.Data;
import hr.java.production.model.Factory;
import hr.java.production.model.Item;
import hr.java.production.model.Person;
import hr.java.production.model.WeedCookies;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        Person p1 = new Person("Aleksandar", "Radovan", "41131854720");
        Person p2 = new Person("Ivan", "Pernar", "41131854720");
        Person[] pArr = {p1,p2};
        Auth.getInstance().setUser(p1);
        CategoryController categoryController = new CategoryController();
        categoryController.create(2);
        ItemController itemController = new ItemController();
        itemController.create(10);
        Auth.getInstance().setUser(p2);
        itemController.create(2);

        //EdibleController edibleController = new EdibleController();
        //edibleController.create(4);

        //System.out.println(edibleController.getHightestCalorieItem());
        //System.out.println(edibleController.getHighestPriceToWeight());

        //FactoryController factoryController = new FactoryController(new AddressController());
        //factoryController.create(2);

        //StoreController storeController = new StoreController();
        //storeController.create(2);

        //System.out.println(factoryController.getHighestVolumeFactory());
        //System.out.println(storeController.getCheapestItems());

        //for (Person person : pArr) {
           //person.printItemsCreatedByPerson(itemController.index());
        //}
    }
}
