package hr.java.production.controller;

import hr.java.production.helpers.DataBuilder;
import hr.java.production.database.Data;
import hr.java.production.helpers.SelectHelper;
import hr.java.production.model.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ItemController implements BaseController<Item> {
    public ArrayList<Item> index() {
        return Data.getInstance().itemList;
    }

    public <T extends Item> T create(Class<T> clazz){
        try {
            return getInputAndCreate(clazz);
        } catch (InputMismatchException e) {
           create(clazz);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    public Item create() {
        return null;
    }

    public void create(int n) {

        for (int i = 0; i < n; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Which class do you want to create?");
            System.out.println("0. Item class");
            System.out.println("1. Laptop class");
            System.out.println("2. PotBrownie class");
            System.out.println("3. WeedCookie class");
            int x = scanner.nextInt();
            while (x > 3 && x < 0) {
                x = scanner.nextInt();
            }
            Class clazz = null;
            if (x == 0) clazz = Item.class;
            else if (x == 1) clazz = Laptop.class;
            else if (x == 3) clazz = PotBrownies.class;
            else if (x == 4) clazz = WeedCookies.class;
            create(clazz);
        }
    }

    private <T extends Item> T getInputAndCreate(Class<T> clazz) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create an item");
        System.out.println("Enter name");
        String _name = scanner.nextLine();
        Category _category = CategoryController.select();
        System.out.println("Enter description");
        String _description = scanner.nextLine();
        System.out.println("Enter width");
        BigDecimal _wid = scanner.nextBigDecimal();
        System.out.println("Enter height");
        BigDecimal _ht = scanner.nextBigDecimal();
        System.out.println("Enter length");
        BigDecimal _len = scanner.nextBigDecimal();
        System.out.println("Enter production cost");
        BigDecimal _prodCost = scanner.nextBigDecimal();
        System.out.println("Enter selling price");
        BigDecimal _sellPrice = scanner.nextBigDecimal();
        System.out.println("Enter discount");
        BigDecimal _discount = scanner.nextBigDecimal();
        BigDecimal _weight = null;
        int _monthsOfWarranty = 0;
        Method createMethod = clazz.getMethod("create", Map.class);
        if (createMethod != null) {
            DataBuilder dataMap = new DataBuilder("name", _name, "category", _category, "width", _wid, "height", _ht, "length", _len, "productionCost", _prodCost, "sellingPrice", _sellPrice);
            if (clazz == PotBrownies.class || clazz == WeedCookies.class) {
                System.out.println("Enter weight");
                _weight = scanner.nextBigDecimal();
                dataMap.add("weight", _weight);
            } else if (clazz == Laptop.class) {
                System.out.println("Enter number of months for warranty");
                _monthsOfWarranty = scanner.nextInt();
                dataMap.add("warrantyMonths", _monthsOfWarranty);
            }
            Item instance = (Item) createMethod.invoke(dataMap.build());
            Data.getInstance().itemList.add(instance);
            return (T) instance;
        }
        return null;
    }

    public static ArrayList<Item> selectMultiple() {
        return new SelectHelper<Item>(Data.getInstance().itemList, "Item").selectMultiple();
    }

    public void delete() {

    }

    public Edible getHightestCalorieItem() {
        Edible highestCalorieItem = null;
        BigDecimal highestCalorie = BigDecimal.ZERO;
        for (Item item : Data.getInstance().itemList) {
            if (item instanceof Edible) {
                Edible edibleItem = (Edible) item;
                if (edibleItem.calculateKilocalories().compareTo(highestCalorie) > 0) {
                    highestCalorie = edibleItem.calculateKilocalories();
                    highestCalorieItem = edibleItem;
                }
            }
        }
        return highestCalorieItem;
    }

    public Edible getHighestPriceToWeight() {
        Edible mostExpensive = null;
        BigDecimal highestPrice = BigDecimal.ZERO;
        for (Item item : Data.getInstance().itemList) {
            if (item instanceof Edible) {
                Edible edibleItem = (Edible) item;
                if (edibleItem.calculatePriceRatio().compareTo(highestPrice) > 0) {
                    highestPrice = edibleItem.calculatePriceRatio();
                    mostExpensive = edibleItem;
                }
            }
        }
        return mostExpensive;
    }

    public Laptop getLowestWarranty() {
        Laptop lowestWarranty = null;
        int lowestMonth = Integer.MAX_VALUE;
        for (Item item : Data.getInstance().itemList) {
            if (item instanceof Laptop) {
                Laptop laptopItem = (Laptop) item;
                if (laptopItem.getWarrantyMonths() < lowestMonth) {
                    lowestMonth = laptopItem.getWarrantyMonths();
                    lowestWarranty = laptopItem;
                }
            }
        }
        return lowestWarranty;
    }
}
