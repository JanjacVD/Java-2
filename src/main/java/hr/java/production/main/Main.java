package hr.java.production.main;

import hr.java.production.auth.Auth;
import hr.java.production.controller.*;
import hr.java.production.database.Data;
import hr.java.production.enums.Priority;
import hr.java.production.exception.ExtractException;
import hr.java.production.helpers.PrintItemQueue;
import hr.java.production.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("ALL")
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    /**
     *
     * @param args
     */


    private static BigDecimal calculateAverageVolume(List<Item> items) {
        if (items.isEmpty()) {
            return BigDecimal.ZERO;
        }
        BigDecimal totalVolume = items.stream()
                .map(Item::calculateVolume)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalVolume.divide(BigDecimal.valueOf(items.size()), BigDecimal.ROUND_HALF_UP);
    }

    private static long countItemsWithAboveAverageVolume(List<Item> items) {
        BigDecimal averageVolume = calculateAverageVolume(items);

        return items.stream()
                .filter(item -> item.calculateVolume().compareTo(averageVolume) > 0)
                .count();
    }
    public static void main(String args[]) {
        Person p1 = new Person("Aleksandar", "Radovan", "41131854720");
        //Person p2 = new Person("Ivan", "Pernar", "41131854720");
        //Person[] pArr = {p1,p2};
        //Auth.getInstance().setUser(p1);
        //CategoryController categoryController = new CategoryController();
        //categoryController.create(2);
        //ItemController itemController = new ItemController();
        ///itemController.create(10);
        //Auth.getInstance().setUser(p2);
        //itemController.create(2);
        Category cat = new Category("Test", "opis");
        BigDecimal dimension = BigDecimal.ONE;
        MobileItem mobile = new MobileItem("Mobitel", cat, p1, dimension, dimension, dimension, dimension, dimension, dimension);
        MobileItem mobile2 = new MobileItem("Mobitel2", cat, p1, dimension, dimension, dimension, dimension, dimension, dimension);
        MobileItem mobile3 = new MobileItem("Mobitel3", cat, p1, dimension, dimension, dimension, dimension, dimension, dimension);
        MobileItem mobile4 = new MobileItem("Mobitel4", cat, p1, dimension, dimension, dimension, dimension, dimension, dimension);
        MobileItem mobile5 = new MobileItem("Mobitel5", cat, p1, dimension, dimension, dimension, dimension, dimension, dimension);
        MobileItem mobile6 = new MobileItem("Mobitel6", cat, p1, dimension, dimension, dimension, dimension, dimension, dimension);
        MobileItem mobile7 = new MobileItem("Mobitel7", cat, p1, dimension, dimension, dimension, dimension, dimension, dimension);
        MobileItem mobile8 = new MobileItem("Mobitel8", cat, p1, dimension, dimension, dimension, dimension, dimension, dimension);

        PrintItemQueue.addToQueue(mobile, Priority.LOW);
        PrintItemQueue.addToQueue(mobile2, Priority.HIGH);
        PrintItemQueue.addToQueue(mobile3, Priority.LOW);
        PrintItemQueue.addToQueue(mobile4, Priority.MEDIUM);
        PrintItemQueue.addToQueue(mobile5, Priority.MEDIUM);
        PrintItemQueue.addToQueue(mobile6, Priority.HIGH);
        PrintItemQueue.addToQueue(mobile7, Priority.MEDIUM);
        PrintItemQueue.addToQueue(mobile8, Priority.LOW);

        PrintItemQueue.doPrint();
//        try{
//            System.out.println(cat.extract("test"));
//        }
//        catch (ExtractException e){
//            logger.error(e.getMessage());
//        }
//
//        List<Item> allItems = (List<Item>)
//                Data.getInstance().storeList.stream()
//                .flatMap(store -> store.getItems().stream())
//                .collect(Collectors.toList());
//
//        Collections.sort(allItems, Comparator.comparing(item -> item.calculateVolume()));
//
//
//        allItems.forEach(item -> System.out.println(item.getName() + ": " + item.calculateVolume()));
//
//        long count = countItemsWithAboveAverageVolume(allItems);
//        BigDecimal averagePrice = allItems.stream()
//                .filter(item -> item.calculateVolume().compareTo(calculateAverageVolume(allItems)) > 0)
//                .map(item -> item.getSellingPrice())  // Pretpostavljamo da postoji metoda getPrice() koja vraća cijenu artikla
//                .reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(count == 0 ? 1 : count), BigDecimal.ROUND_HALF_UP);
//
//
//        System.out.println("Srednja cijena artikala s natprosječnim volumenom: " + averagePrice);
//
//
//        double averageNumberOfItems = Data.getInstance().storeList.stream()
//                .mapToInt(store -> store.getItems().size())
//                .average()
//                .orElse(0.0);
//
//        List<Store> storesWithAboveAverageItems = Data.getInstance().storeList.stream()
//                .filter(store -> store.getItems().size() > averageNumberOfItems)
//                .collect(Collectors.toList());
//
//
//        storesWithAboveAverageItems.forEach(store -> System.out.println(store.getName()));
//
//
//        ArrayList<Item> items =
//                Data.getInstance().itemList;
//
//        Stream<Item> result = items.stream().filter(x -> x.getDiscount().discountAmount().compareTo(BigDecimal.ZERO) > 0);
//        Optional<Item> resultItem = items.stream().filter(item -> item.getDiscount().discountAmount().compareTo(BigDecimal.ZERO) > 0)
//                .findFirst();
//
//        resultItem.ifPresentOrElse(
//                item -> System.out.println("Item with discount greater than 0 found: " + item),
//                () -> System.out.println("No item with discount greater than 0 found.")
//        );
//
//        List<String> itemCountsPerStore = Data.getInstance().storeList.stream()
//                .map(store -> store.getItems().size() + " items in " + store.getName())
//                .collect(Collectors.toList());

        // Ispis broja artikala u svakoj trgovini
//        itemCountsPerStore.forEach(System.out::println);
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
