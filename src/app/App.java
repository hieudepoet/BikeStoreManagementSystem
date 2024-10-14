    package app;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import service.ProductService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        AtomicBoolean running  = new AtomicBoolean(true);
        ProductService product_service = new ProductService();


        while (running.get()) {
            System.out.println("1. Add a product. ");
            System.out.println("2. Search product by product name, return a list of all products that same name. ");
            System.out.println("3. Update product. ");
            System.out.println("4. Delete product.");
            System.out.println("5. Save products to file.");
            System.out.println("6. Print list products from the file. ");
            //System.out.println("7. Add a brand.");
            System.out.println("Others - Quit");
            System.out.print("Your option : ");
            int option;
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: //done
                    product_service.addProduct();

                    askToGoBacKTheMenu(sc, running);
                    break;
                    
                case 2: //done
                    System.out.print("Enter the product name : ");
                    product_service.searchProductByName(sc.nextLine().trim());
        
                    askToGoBacKTheMenu(sc, running);
                    break;

                case 3: //done
                    System.out.print("Enter the product's id : ");
                    product_service.updateProduct(sc.nextLine().trim());

                    askToGoBacKTheMenu(sc, running);
                    break;

                case 4: //done
                    System.out.print("Enters the id : ");
                    String id = sc.nextLine().trim();
                    product_service.deleteProduct(id);

                    askToGoBacKTheMenu(sc, running);
                    break;

                case 5: //done
                    product_service.saveToFile();

                    askToGoBacKTheMenu(sc, running);
                    break;

                case 6: //done
                    product_service.display();
                    askToGoBacKTheMenu(sc, running);
                    break;
                    
//                case 7: 
//                    product_service.addBrand();
//                    askToGoBacKTheMenu(sc, running);
//                    break;

                default:
                    System.out.println("Program is ending...");
                    
                    System.out.print("Save the change? (Y/N) : ");
                    if (sc.nextLine().trim().equalsIgnoreCase("Y")) {                     
                        product_service.saveToFile();
                    }
                    running.set(false);
            }
            
            if (!running.get()) {
                System.out.println("Program is ending...");
                
                System.out.print("Save the change? (Y/N) : ");
                if (sc.nextLine().trim().equalsIgnoreCase("Y")) {
                    product_service.saveToFile();
                }
            }
        }

        System.out.println("End.");
    }

    public static void askToGoBacKTheMenu(Scanner sc, AtomicBoolean running) {
        System.out.print("Go back to the main menu? (Y/N) : ");
        if (sc.nextLine().equalsIgnoreCase("N")) running.set(false);
    }
}
