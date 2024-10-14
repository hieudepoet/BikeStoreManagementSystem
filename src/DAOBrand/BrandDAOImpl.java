package DAOBrand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import model.Brand;
import util.BrandFileUtil;
import validator.Validator;

public class BrandDAOImpl extends HashMap<String, String> implements BrandDAO{
    private BrandFileUtil bfu = new BrandFileUtil();
    private List<Brand> brands = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
            
    public BrandDAOImpl() {
        super();
        
        brands = bfu.readFile("D:\\Code\\NetBeansProjects\\BikeStoresManagementSystem\\src\\data\\Brand.txt");
        
        this.clear();
        for (Brand brand : brands) {
            this.put(brand.getBcode(), brand.getBname());
        } 
    }

    @Override
    public List<Brand> getAll() {      
        return brands;
    }
    
    public Brand item() {
        String brand_id = new String();
        String brand_name = new String();
        String brand_country = new String(); 
        
        //Enter_id
        System.out.print("Enter id : ");
        brand_id = sc.nextLine().trim();
        
        while (Validator.isBrandIdValid(brand_id)){
            System.out.print("Existed id. Please enter again : ");
            brand_id = sc.nextLine().trim();
        }
        
        //Enter name
        System.out.print("Enter name : ");
        brand_name = sc.nextLine().trim();

        while (!Validator.isNameValid(brand_name)) {
            System.out.print("Invalid name. Please enter again : ");
            brand_name = sc.nextLine().trim();
        }
        
        //Enter country
        System.out.print("Enter country : ");
        brand_country = sc.nextLine();
        
        return new Brand(brand_id, brand_name, brand_country);
    }

    @Override
    public void add() {
        System.out.println("=====================Brand List=====================");
        
        for (Brand brand : brands) {
            System.out.println(brand);
        }
        
        System.out.println("");
        Brand brand = item();
        brands.add(brand);
        this.put(brand.getBcode(), brand.getBname());
        bfu.writeFile("D:\\Code\\NetBeansProjects\\BikeStoresManagementSystem\\src\\data\\Brand.txt", brands);
        System.out.println("Success.");
    }
    
    

    @Override
    public void search(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Do not have access!");
    }

    @Override
    public void update(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Do not have access!");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Do not have access!");
    }
}
