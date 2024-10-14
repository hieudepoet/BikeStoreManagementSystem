package Validator;

import java.util.List;

import DAOBrand.BrandDAOImpl;
import DAOCategory.CategoryDAOImpl;
import DAOProduct.ProductDAOImpl;
import model.Product;

public class Validator {
    public static boolean isIdValid(String id, ProductDAOImpl p) {
        boolean check = true;

//        ProductDAOImpl p = new ProductDAOImpl();
        //List<Product> products = p.getAll();
        for(Product product : p) {
            if (product.getId().equals(id)) {
                check = false;
                break;
            }
        }
        return check;
    }

    public static boolean isNameValid(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isBrandIdValid(String brand_id) {
        
        BrandDAOImpl b = new BrandDAOImpl();
        
        if (b.containsKey(brand_id)) return true;
        return false;
    }

    public static boolean isCategoryIdValid(String category_id) {
        
        CategoryDAOImpl c = new CategoryDAOImpl();
        if (c.containsKey(category_id)) return true;
        return false;
    }

    public static boolean isYearValid(String year) {
        boolean check = true;
        int model_year = 0;
        try {
            model_year = Integer.parseInt(year); 
        }
        catch (NumberFormatException e) {
            check = false;
        }
        if (check)
            return model_year >= 1900 && model_year <= java.time.Year.now().getValue();
        else return check;
    }

    public static boolean isPriceValid(String price) {
        boolean check = true;
        double list_price = 0;
        try {
            list_price = Double.parseDouble(price);
        }
        catch (NumberFormatException e) {
            check = false;
        }
        
        if (check) 
            return list_price > 0;
        else return check;
    }
}
