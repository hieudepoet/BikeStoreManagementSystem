package service;

import DAOBrand.BrandDAOImpl;
import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import DAOProduct.*;


public class ProductService {
    Scanner sc = new Scanner(System.in);
    private final ProductDAOImpl productDAO;
    private final BrandDAOImpl brandDAO;

    public ProductService() {
        this.productDAO = new ProductDAOImpl();
        this.brandDAO = new BrandDAOImpl();
    }

    public void addProduct() {
        productDAO.add();
    }

    public void searchProductByName(String name) {
        productDAO.search(name);
    }

    public void updateProduct(String id) {
        productDAO.update(id);
    }

    public void deleteProduct(String id) {
        productDAO.delete(id);
    }

    public void saveToFile(){
        productDAO.saveToFile();
    }

    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }
    
    public void addBrand() {
        brandDAO.add();
    }

    public void display() {
        List<Product> products = new ArrayList<Product>();
        products = getAllProducts();
        Collections.sort(products);
        for(Product product : products) 
            System.out.println(product);
    }
}
