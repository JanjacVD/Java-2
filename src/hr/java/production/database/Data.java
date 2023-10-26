package hr.java.production.database;

import hr.java.production.model.*;

import java.util.ArrayList;

public class Data {
    //This class will just handle all the storage of data for now,
    // later could be expanded to handle database connection
    private static Data instance;
    public Data(){}
    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }
    public final ArrayList<Category> categoryList = new ArrayList<>();
    public final ArrayList<Person> personList = new ArrayList<Person>();
    public final ArrayList<Address> addressList = new ArrayList<Address>();
    public final ArrayList<Factory> factoryList = new ArrayList<Factory>();
    public final ArrayList<Store> storeList = new ArrayList<Store>();
    public final ArrayList<Item> itemList = new ArrayList<Item>();
    public final ArrayList<Edible> edibleItemList = new ArrayList<Edible>();


}
