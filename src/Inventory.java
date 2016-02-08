import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Caroline on 2/8/16.
 */
public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        InventoryItem apples = new InventoryItem("Apples", 10);
        InventoryItem pears = new InventoryItem("Pears", 5);
        InventoryItem bananas = new InventoryItem("Bananas", 7);

        ArrayList<InventoryItem> items = new ArrayList<>();
        items.add(apples);
        items.add(pears);
        items.add(bananas);

        int index = 1;

        for (InventoryItem x : items) {
            System.out.println(index + "." + "[" + x.quantity + "]" + x.itemName);
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

                InventoryItem item = new InventoryItem(itemName, quantity);
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
                    System.out.println(i + "." + "[" + x.quantity + "]" + x.itemName);
                    i ++;
                }
            }
        }
    }
}







