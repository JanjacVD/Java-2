package hr.java.production.helpers;

import hr.java.production.database.Data;
import hr.java.production.model.Category;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectHelper<T> {
    ArrayList<T> data;
    String nameOfSelection;
    Scanner scanner = new Scanner(System.in);

    public SelectHelper(ArrayList<T> _data, String _nameOfSelection){
        this.data = _data;
        this.nameOfSelection = _nameOfSelection;
    }
    private T handleSelection(ArrayList<T> selectOptions){
        try {
            int size = selectOptions.size();
            if (size == 0) {
                System.out.println("No " + nameOfSelection +  " exists in array");
                return null;
            }
            System.out.println("Select a " + nameOfSelection);
            for (int i = 0; i < selectOptions.size(); i++) {
                T entry = selectOptions.get(i);
                System.out.println(i + ". " + entry);
            }
            int selectedIndex = scanner.nextInt();
            return selectOptions.get(selectedIndex);
        } catch (Exception e) {
            System.out.println("Error choosing " +nameOfSelection+" , try again");
            return handleSelection(selectOptions);
        }
    }
    public T selectSingle(){
        return handleSelection(this.data);
    }


    public ArrayList<T> selectMultiple(){
        ArrayList<T> selectedOptions = new ArrayList<T>();
        ArrayList<T> options = new ArrayList<>(this.data);
        if(data.isEmpty()) return selectedOptions;
        T selectedItem = handleSelection(options);
        selectedOptions.add(selectedItem);
        options.remove(selectedItem);
        boolean userWantsToAddAnotherItem = checkIfUserWantsToAddAnotherItem();
        while (userWantsToAddAnotherItem && !options.isEmpty()){
            selectedItem = handleSelection(options);
            if(selectedItem != null){
                selectedOptions.add(selectedItem);
                options.remove(selectedItem);
                userWantsToAddAnotherItem = checkIfUserWantsToAddAnotherItem();
            }
            else return selectedOptions;
        }
        return selectedOptions;
    }
    public boolean checkIfUserWantsToAddAnotherItem(){
        System.out.println("Do you want to select another item?");
        System.out.println("0 -> No");
        System.out.println("1 -> Yes");
        return scanner.nextInt() == 1;
    }
}
