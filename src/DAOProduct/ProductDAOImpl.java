package DAOProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import DAOBrand.BrandDAOImpl;
import DAOCategory.CategoryDAOImpl;

import java.util.Collections;
import java.util.Comparator;
import model.Brand;
import model.Category;
import model.Product;
import util.ProductFileUtil;
import validator.Validator;

public class ProductDAOImpl extends ArrayList<Product> implements ProductDAO{
    Scanner sc = new Scanner(System.in);
    private ProductFileUtil pfu = new ProductFileUtil();

    public ProductDAOImpl() {
        super();
        List<Product> productsFromFile = getAll();
        if(productsFromFile != null) 
            this.addAll(productsFromFile);
    }
    
    public Product item(int status, Product p) {
        String bname = new String();
        String cname = new String();
        BrandDAOImpl brandDAO = new BrandDAOImpl();
        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();


        //Enter id
        String id;
        if (status == 1) {
            System.out.print("Enter id : ");
            id = sc.nextLine().trim();
        
            while (!Validator.isIdValid(id, this)){
                System.out.print("Existed id. Please enter again : ");
                id = sc.nextLine().trim();
            }
        }
        else id = p.getId();

        //Enter name
        System.out.print("Enter name : ");
        String name = sc.nextLine().trim();

        if (name.isEmpty() && status == 2) 
            name = p.getName(); 
        else while (!Validator.isNameValid(name)) {
            System.out.print("Invalid name. Please enter again : ");
            name = sc.nextLine().trim();
        }

        //Enter brand_id
        System.out.println("=====================Brand List=====================");
        
        List<Brand> brand_list = brandDAO.getAll();
        for (Brand brand : brand_list) {
            System.out.println(brand);
        }
        
        System.out.println("");
        
        System.out.print("Enter brand_id : ");
        String brand_id = sc.nextLine().trim();
        
        if (brandDAO.isEmpty()) {
            System.out.println("File Brand.txt is empty!");
            return null;
        }

        if(brand_id.isEmpty() && status == 2) {
            bname = p.getBrand_name();
        }
        else while (!Validator.isBrandIdValid(brand_id)) {
            System.out.print("Not found brand_id. Please enter again : ");
            brand_id = sc.nextLine().trim();
            if(brand_id.isEmpty() && status == 2) {
                bname = p.getBrand_name();
                break;
            }
        }

        //Enter category_id
        System.out.println("=====================Category List=====================");
        
        List<Category> category_list = categoryDAO.getAll();
        for (Category category : category_list) {
            System.out.println(category);
        }
        
        System.out.println("");
        
        System.out.print("Enter category_id : ");
        String category_id = sc.nextLine().trim();
        
        if(categoryDAO.isEmpty()) {
            System.out.println("File Category.txt  is empty!");
            return null;
        }

        if(category_id.isEmpty() && status == 2) {
            cname = p.getCategory_name();
        }
        else while (!Validator.isCategoryIdValid(category_id)) {
            System.out.print("Not found category_id. Please enter again : ");
            category_id = sc.nextLine().trim();
            if(category_id.isEmpty() && status == 2) {
                cname = p.getCategory_name();
                break;
            }
        }

        //Enter model_year
        System.out.print("Enter model_year : ");
        String year = sc.nextLine().trim();
        int model_year = 0;

        if (Validator.isYearValid(year)) 
            model_year = Integer.parseInt(year);
        
        if(year.isEmpty() && status == 2) {
            model_year = p.getModel_year();     
        }
        else while (!Validator.isYearValid(year)) {
            System.out.print("Invalid year. Please enter again : ");
            year = sc.nextLine().trim();

            if (Validator.isYearValid(year)) 
                model_year = Integer.parseInt(year);

            if(year.isEmpty() && status == 2) {
                model_year = p.getModel_year();
                break;
            }
        }
        

        //Enter list_price
        System.out.print("Enter list_price : ");
        String price = sc.nextLine().trim();
        double list_price = 0;
        
        if (Validator.isPriceValid(price))    
                list_price = Double.parseDouble(price);
        
        if(price.isEmpty() && status == 2) {
            list_price = p.getList_price();     
        }
        else while (!Validator.isPriceValid(price)) {
            System.out.print("Invalid price. Please enter again : ");
            price = sc.nextLine().trim();

            if (Validator.isPriceValid(price))    
                list_price = Double.parseDouble(price);

            if(price.isEmpty() && status == 2) {
                list_price = p.getList_price();
                break;
            }
        }

        //Get brand_name
        String brand_name;
        if (status ==  2 && !bname.isEmpty()) {
            brand_name = bname;
        }
        else {
            brand_name = brandDAO.get(brand_id).trim();
        }

        //Get category_name
        String category_name;
        if (status == 2 && !cname.isEmpty()) {
            category_name = cname;
        }
        else {
            category_name = categoryDAO.get(category_id).trim();
        }
        
        //Set the status
        String status_of_product = new String();
        if(model_year <= 2020) 
            status_of_product = "old";
        else 
            status_of_product = "new";
        
        Product product = new Product(id, name, brand_name, category_name, model_year, list_price, status_of_product);  

        return product;
    }

    @Override
    public void add() {
        Product p = item(1, null);
        if (p == null) {
            System.out.println("Fail!");
            return;
        }
        this.add(p);   
        System.out.println("Success");
        
        System.out.print("Save the change? (Y/N) : ");
        if (sc.nextLine().trim().equalsIgnoreCase("Y")) {
            saveToFile();
        }
        else 
            System.out.println("You should turn back to the main menu and select [5. Save products to file.] to save changes."); 
    }

    @Override
    public void search(String name) {
        if(this.isEmpty()) {
            System.out.println("Have no any Product");
        }
        
        // List<Product> result = new ArrayList<>();
        // for (Product product : this) {
        //     if (product.getName().toLowerCase().contains(name.toLowerCase()))
        //         result.add(product);
        // }
        
        List<Product> result = this.stream()
                        .filter(product -> product.getName().equalsIgnoreCase(name))
                        .collect(Collectors.toList());

        Collections.sort(result, new Comparator<Product>() {                                          
            public int compare(Product p1, Product p2) {
                //Student s1 = (Student) o1;
                //Student s2 = (Student) o2;
                return Integer.compare(p2.getModel_year(), p1.getModel_year());
            }
        });

        if (result.isEmpty()) {
            System.out.println("No products found with the name: " + name);
        }
        else {
            for (Product product : result) {
                System.out.println(product.toString());
            }
        }
    }


    @Override
    public void update(String id) {
        boolean check = false;

        for(Product product : this) {
            if(product.getId().equals(id)) {
                check = true;

                Product newp = item(2, product);
                int index = this.indexOf(product);
                System.out.print("Update information for this product? (Y/N) : ");
                if (sc.nextLine().equalsIgnoreCase("Y")) {
                    this.set(index, newp);
                    
                    System.out.println("Success!");
                    
                    System.out.print("Save the change? (Y/N) : ");
                    if (sc.nextLine().trim().equalsIgnoreCase("Y")) {
                        saveToFile();
                    }
                    else 
                        System.out.println("You should turn back to the main menu and select [5. Save products to file.] to save changes."); 
                }
                else 
                    System.out.println("Fail! Update cancelled.");

                break;
            }
        }
        
        if(!check) System.out.println("Product does not exist.");
    }

    @Override
    public void delete(String id) {
        System.out.print("Delete the product? (Y/N) : ");
        if(sc.nextLine().equalsIgnoreCase("N"))
            return;

        boolean isReomved = this.removeIf(product -> product.getId().equals(id));
    
        if(isReomved) {
            System.out.println("Success!");
            
            System.out.print("Save the change? (Y/N) : ");
            if (sc.nextLine().trim().equalsIgnoreCase("Y")) {        
                saveToFile();
            }
            else 
                System.out.println("You should turn back to the main menu and select [5. Save products to file.] to save changes."); 
        }
        else {
            System.out.println("Fail! Product is not exist");
        }
    }

    @Override
    public void saveToFile() {
        pfu.writeFile("D:\\Code\\NetBeansProjects\\BikeStoresManagementSystem\\src\\data\\Product.txt", this);
        System.out.println("Saved!");
    }

    @Override
    public List<Product> getAll() {
        return pfu.readFile("D:\\Code\\NetBeansProjects\\BikeStoresManagementSystem\\src\\data\\Product.txt");
    }
}
