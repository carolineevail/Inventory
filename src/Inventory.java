import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Caroline on 2/8/16.
 */
public class Inventory {
    public static InventoryItem createItem(String name, int quantity, String category) throws Exception {
        if (category.equalsIgnoreCase("Fruit")) {
            return new Fruit(name, quantity);
        }

        if (category.equalsIgnoreCase("Vegetable")) {
            return new Vegetable(name, quantity);
        }

        else if (category.equalsIgnoreCase("Meat")) {
            return new Meat(name, quantity);
        }

        else if (category.equalsIgnoreCase("Cheese")) {
            return new Cheese(name, quantity);
        }

        else if (category.equalsIgnoreCase("Drink")) {
            return new Drink(name, quantity);
        }
        else {
            throw new Exception("Invalid category name.");
        }
    }
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);


        Fruit apples = new Fruit("Apples", 10);
        Fruit pears = new Fruit("Pears", 5);
        Fruit bananas = new Fruit("Bananas", 7);

        ArrayList<InventoryItem> items = new ArrayList<>();
        items.add(apples);
        items.add(pears);
        items.add(bananas);

        int index = 1;

        for (InventoryItem x : items) {
            System.out.printf("%d. [%d] %s\n", index, x.quantity, x.itemName);
            index ++;
        }


        while (true) {
            System.out.println("[1] Create a new item");
            System.out.println("[2] Remove an item");
            System.out.println("[3] Update an item's quantity");
            System.out.println("[4] Check inventory");

            String option = scanner.nextLine();

            if (option.equals("1")) {
                System.out.println("Enter new item:");
                String itemName = scanner.nextLine();

                System.out.println("Enter quantity of new item:");
                int quantity = Integer.valueOf(scanner.nextLine());

                System.out.println("Enter category name:");
                String category = scanner.nextLine();

                InventoryItem item = createItem(itemName, quantity, category);
                items.add(item);
            }
            else if (option.equals("2")) {
                System.out.println("Enter the item number you would like to remove:");
                int itemNumber = Integer.valueOf(scanner.nextLine());
                items.remove(itemNumber - 1);
            }
            else if (option.equals("3")) {
                System.out.println("Enter list number of item whose quantity you'd like update:");
                int indexOfItemToUpdate = Integer.valueOf(scanner.nextLine()) - 1;
                System.out.println("What is the new quantity?");
                int newQuantity = Integer.valueOf(scanner.nextLine());
                items.get(indexOfItemToUpdate).quantity = newQuantity;
            }
            else if (option.equals("4")) {
                int i = 1;

                for (InventoryItem x : items) {
                    System.out.printf("%d. [%d] %s, %s\n", i, x.quantity, x.itemName, x.category);
                    i ++;
                }
            }
        }
    }
}







