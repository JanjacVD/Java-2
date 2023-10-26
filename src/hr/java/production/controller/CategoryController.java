package hr.java.production.controller;

import hr.java.production.helpers.DataBuilder;
import hr.java.production.database.Data;
import hr.java.production.helpers.SelectHelper;
import hr.java.production.model.Category;

import java.util.ArrayList;
import java.util.Scanner;

public class CategoryController implements BaseController<Category> {
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
            Data.getInstance().categoryList.add(newCat);
            return newCat;
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

    public static Category select() {
        return new SelectHelper<Category>(Data.getInstance().categoryList, "Category").selectSingle();
    }

    public void delete() {

    }
}
