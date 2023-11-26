package hr.java.production.controller;

import hr.java.production.helpers.DataBuilder;
import hr.java.production.database.Data;
import hr.java.production.helpers.SelectHelper;
import hr.java.production.model.Category;
import hr.java.production.exception.DuplicateCategoryException;

import java.util.ArrayList;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CategoryController implements BaseController<Category> {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    public ArrayList<Category> index() {
        return Data.getInstance().categoryList;
    }

    public Category create() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Create a category");
            System.out.println("Enter name");
            String _name = scanner.nextLine();
            System.out.println("Enter description");
            String _description = scanner.nextLine();
            Category newCat = Category.create(new DataBuilder("name", _name, "description", _description).build());
            addToArr(newCat);
            return newCat;
        } catch (DuplicateCategoryException e) {
            logger.info("Base:",e);
            System.out.println("Kategorija već unesena. Molimo unesite kategoriju s drugačijim imenom.");
            return create();
        }
    }
    public void addToArr(Category cat){
        int count = 0;
        for (Category category : Data.getInstance().categoryList) {
            if (category.getName().equals(cat.getName())) {
                count++;
                if (count >= 2) {
                    throw new DuplicateCategoryException("Kategorija već unesena. Molimo unesite kategoriju s drugačijim imenom.");
                }
            }
        }
        Data.getInstance().categoryList.add(cat);
    }
    public void create(int n) {
        for (int i = 0; i < n; i++) {
            create();
        }
    }

    public static Category select() {
        return new SelectHelper<Category>(Data.getInstance().categoryList, "Category").selectSingle();
    }

    public void delete() {

    }
}
