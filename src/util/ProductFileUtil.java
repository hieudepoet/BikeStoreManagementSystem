package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductFileUtil extends FileUtil<Product>{
    @Override
    public List<Product> readFile(String filePath) {
        List<Product> products = new ArrayList<Product>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                try {
                    String[]  data = line.split(",");
                    Product product = new Product(
                        data[0].trim(),
                        data[1].trim(),
                        data[2].trim(),
                        data[3].trim(),
                        Integer.parseInt(data[4].trim()),
                        Double.parseDouble(data[5].trim()),
                        data[6].trim()
                    );

                    products.add(product);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid data syntax");
                }
            }
        }catch (IOException e) {
            System.out.println("An error occurred while trying to access the file. Please check if the file exists and is accessible.");
        }

        return products;
    }

    @Override
    public void writeFile(String filePath, List<Product> products) {
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for(Product product : products) {
                writer.write(product.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving to the file. Please check the file or try again.");
        }
    }
}
