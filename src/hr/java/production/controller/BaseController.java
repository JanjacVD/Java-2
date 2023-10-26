package hr.java.production.controller;

import hr.java.production.model.Edible;
import hr.java.production.model.Factory;
import hr.java.production.model.Item;
import hr.java.production.model.Laptop;

import java.util.ArrayList;

public interface BaseController<T> {
    public ArrayList<T> index();
    public T create();
    public void create(int n);
    public void delete();
    default T create(AddressController addressController) {
        // Provide a default implementation here, e.g., return null.
        return null;
    }
    default <T extends Item> T create(Class<T> clazz) {
        return null;
    }

}
