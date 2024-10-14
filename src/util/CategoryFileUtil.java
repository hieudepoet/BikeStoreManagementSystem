package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Category;

public class CategoryFileUtil extends FileUtil<Category>{

    @Override
    public List<Category> readFile(String filePath) {
        List<Category> categorys  = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                try {
                    String[]  data = line.split(",");
                    Category category = new Category(
                        data[0].trim(),
                        data[1].trim()
                    );

                    categorys.add(category);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return categorys;
    }
}
