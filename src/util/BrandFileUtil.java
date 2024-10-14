package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Brand;
import model.Product;

public class BrandFileUtil extends FileUtil<Brand>{

    @Override
    public List<Brand> readFile(String filePath) {
        List<Brand> brands  = new ArrayList<Brand>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                try {
                    String[]  data = line.split(",");
                    
                    Brand brand = new Brand(
                        data[0].trim(),
                        data[1].trim(),
                        data[2].trim()
                    );

                    brands.add(brand);
                } catch (Exception e) {
                    System.out.println("Wrong format.");
                    //e.printStackTrace();
                }
            }
        }catch (IOException e) {
            System.out.println("File is empty.");
            //e.printStackTrace();
        }

        return brands;
    }
    
    @Override
    public void writeFile(String filePath, List<Brand> brands) {
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for(Brand brand : brands) {
                writer.write(brand.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving to the file. Please check the file or try again.");
        }
    }
}
